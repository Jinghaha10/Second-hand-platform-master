package com.ssm.controller;

// 导入所需的类：
import com.ssm.pojo.*;
import com.ssm.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

// 定义PublishController类，并使用@Controller注解将其标记为Spring的控制器。
@Controller
@RequestMapping("/publish")
public class PublishController {

    // 声明并初始化一个Logger对象，用于记录日志。
    private Logger logger = LoggerFactory.getLogger(PublishController.class);

    // 使用@Resource注解注入一些服务（Service）对象
    @Resource
    private UserService userService;

    @Resource
    private CatelogService catelogService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private ImageService imageService;

    @Resource
    private ReportService reportService;

    /**
     * 处理进入发布界面
     * @param session
     * @return
     */
    // 使用@RequestMapping注解指定了请求的URL路径，即"/publish"。
    @RequestMapping(value = "/publish")
    // 接受一个HttpSession对象作为参数，用于获取会话信息。
    public ModelAndView publish(HttpSession session){
        //通过session判断用户是否登录
        User user = (User)session.getAttribute("cur_user");
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){
            //用户登陆后，将分类信息获取出来
            List<Catelog> catelogs = catelogService.getAllCatelogByStatus((byte)1);
            //返回分类信息
            modelAndView.addObject("catelogs",catelogs);
            modelAndView.setViewName("/user/publish");
            return modelAndView;
        }else{
            //未登录将重定向到登录
            modelAndView.setViewName("redirect:/user/toLogin");
            // 方法的返回类型为ModelAndView，表示返回一个带有数据模型和视图的对象。
            return modelAndView;
        }
    }

    /**
     * 上传 闲置图片
     * @param session session信息
     * @param fileName 图片文件名
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    // 定义一个处理图片上传的方法：
    @ResponseBody
    // @RequestMapping注解指定了请求的URL路径，即"/publish/upload
    @RequestMapping(value = "/publish/upload",method = RequestMethod.POST)
    // 接受一个HttpSession对象和一个HttpServletRequest对象作为参数，以及一个MultipartFile类型的参数fileName，表示上传的文件。
    public Map<String,Object> uploadFile(HttpSession session,HttpServletRequest request, @RequestParam("info") MultipartFile fileName) throws IllegalStateException, IOException{
        //获取上传文件的原名
        String oldFileName = fileName.getOriginalFilename();

        //存储图片的物理路径
        //获取项目部署目录根 （此处为tomcat下的webapps目录路径如 D:\apache-tomcat-7.0.92\webapps，避免项目重新部署后上传的文件被清除丢失）
        File rootPath = new File(request.getServletContext().getRealPath("/")).getParentFile();
        File uploadFile = new File(rootPath.getPath()+"/images/web/");

        if(!uploadFile.exists()){
            uploadFile.mkdirs();
        }

        //上传图片
        if(fileName!=null && oldFileName!=null && oldFileName.length()>0){
            //新的图片名称
            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
            //新图片
            String url = rootPath.getPath()+"/images/web/" + newFileName;
//            logger.info("图片路径=====》"+url);
            //将内存中的数据写入磁盘
            fileName.transferTo(new File(url));
            //将新图片名称返回到前端
            Map<String,Object> map=new HashMap<String,Object>();
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("src",newFileName);
            map.put("success", true);
            map.put("msg", "图片上传成功");
            map.put("data",data);
            return  map;
        }else{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("error","error");
            return map;
        }
    }

    /**
     * 删除上传的缓存 闲置图片
     * @param request request
     * @param fileName 图片名称
     * @return
     */
    // 定义一个删除上传图片的方法
    // 使用@RequestMapping注解指定了请求的URL路径，即"/publish/delete_image"。
    @RequestMapping(value = "/publish/delete_image",method = RequestMethod.POST)
    public @ResponseBody
    // 接受一个HttpServletRequest对象和一个String类型的参数fileName，表示要删除的文件名。
    Map<String,Object> delectUploadFile(HttpServletRequest request, @RequestParam("path") String fileName){
        //获得物理路径
        String true_path = request.getServletContext().getRealPath("/");
        true_path = true_path.replace("\\ROOT", "");
//        System.out.println("删除文件路径："+true_path);
        //设置文件的存储路径
        String file_name = true_path+"\\images\\web\\"+fileName;
        File file1 = new File(file_name);
//        System.out.println("删除文件路径："+file1);
//        System.out.println("删除文件路径："+file1.exists());
        //判断文件是否存在
        if (file1.exists()) {
            try {
                //删除文件
                file1.delete();
            } catch (Exception e) {
                //输出异常信息
                e.printStackTrace();
            }
        }
        //返回信息
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);
        map.put("msg","图片删除成功");
        return  map;
    }

    /**
     * 处理发布闲置
     * @param goods 闲置物品信息
     * @return
     */
    // 定义一个处理发布闲置的方法：
    // 使用@RequestMapping注解指定了请求的URL路径，即"/publish/complete"。
    @RequestMapping(value = "/publish/complete",method = RequestMethod.POST)
    public @ResponseBody
    // 接受一个HttpSession对象、一个Goods对象和一个String类型的参数good_images，用于处理发布闲置物品的请求。
    Map<String,Object> handlePublishComplete(HttpSession session, Goods goods, String good_images){

        System.out.println("publish->CatelogId:"+goods.getCatelogId());

        //设置闲置初始信息
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        goods.setStartTime(sdf.format(new Date()));
        goods.setPolishTime(sdf.format(new Date()));
        goods.setCommetNum(0);
        goods.setViewcount(0);
        //获取用户信息
        User cur_user = (User)session.getAttribute("cur_user");
        User user = userService.selectByPrimaryKey(cur_user.getId());
        goods.setUserId(user.getId());
        goodsService.insert(goods);
        //更新对应的闲置分类数量
        Catelog catelog = catelogService.selectByPrimaryKey(goods.getCatelogId());
        catelogService.updateCatelogNum(goods.getCatelogId(),catelog.getNumber()+1);
        //插入闲置对应的图片信息
        good_images = good_images.substring(good_images.indexOf("\""),good_images.lastIndexOf("]"));
        String[] urls = good_images.split(",");
        for (String url:urls) {
            url = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("\""));
            Image image = new Image(1,goods.getId(),url);
            imageService.insert(image);
        }
        //更新用户闲置物品数量
        userService.updateGoodsNum(user.getId(),user.getGoodsNum()+1);

        User cur_user_new = userService.selectByPrimaryKey(cur_user.getId());

        session.setAttribute("cur_user",cur_user_new);

        //返回响应json数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);
        map.put("msg","成功添加");
        return map;
    }


    @RequestMapping(value = "/update_good",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> delete_good(HttpSession session,@RequestParam("gid")Integer gid){
        User user = (User)session.getAttribute("cur_user");
        Goods goods = goodsService.selectByPrimaryKey(gid);

        System.out.println("gid:"+gid);
        Map<String,Object> map = new HashMap<String,Object>();
        if(user!=null){
            //根据闲置id更新闲置状态
            /*Goods goods = goodsService.selectByPrimaryKey(gid);
            Catelog catelog = catelogService.selectByPrimaryKey(goods.getCatelogId());
            catelogService.updateCatelogNum(goods.getCatelogId(),catelog.getNumber()-1);*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (goods.getStatus() == 1) {
                goodsService.updateStatusByPrimaryKey(gid,(byte)2);
                goodsService.updateEndTimeByPrimaryKey(gid,sdf.format(new Date()));
                map.put("success",true);
                map.put("msg","下架成功");
            } else {
                goodsService.updateStatusByPrimaryKey(gid,(byte)1);
                goodsService.updateEndTimeByPrimaryKey(gid,sdf.format(new Date()));
                map.put("success",true);
                map.put("msg","上架成功");
            }

        }else{
            map.put("success",false);
            map.put("msg","下架失败,请登陆");
        }
        return map;
    }

    @RequestMapping(value = "/reflash",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> reflash_good(HttpSession session,@RequestParam("gid")Integer gid){
        User user = (User)session.getAttribute("cur_user");
        System.out.println("gid:"+gid);
        Map<String,Object> map = new HashMap<String,Object>();
        if(user!=null){
            //根据闲置id擦亮闲置信息
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            goodsService.updatePolishTimeByPrimaryKey(gid,sdf.format(new Date()));
            map.put("success",true);
            map.put("msg","已擦亮");
        }else{
            map.put("success",false);
            map.put("msg","擦亮失败,请登陆");
        }
        return map;
    }

    /**
     *
     * @param gid 闲置物品id
     * @param good_title 闲置物品名称
     * @param description 举报描述
     * @return
     */
    @RequestMapping(value = "/report")
    public @ResponseBody Map<String,Object> report(HttpSession session,@RequestParam("gid")Integer gid,@RequestParam("good_title")String good_title,@RequestParam("description")String description){
        System.out.println("gid:"+gid+", good_title:"+good_title+", description:"+description);
        User user = (User)session.getAttribute("cur_user");
        Report report = new Report(1,gid,user.getId(),description,(byte)0);
        reportService.insert(report);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        map.put("msg","举报成功");
        return map;
    }

}
