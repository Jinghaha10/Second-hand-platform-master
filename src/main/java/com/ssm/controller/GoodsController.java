package com.ssm.controller;

// 导入需要使用的类：

import com.ssm.pojo.*;
import com.ssm.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 声明控制器类：
// 将GoodsController类标记为一个控制器（Controller）
@Controller
// 并映射到"/detail"路径。
@RequestMapping("/detail")
public class GoodsController {
    // 声明并注入服务类的实例：
    // 将需要使用的服务类的实例注入到GoodsController类中。这些服务类包括WantedService、GoodsService、ImageService、CatelogService和UserService。
    @Resource
    private WantedService wantedService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private ImageService imageService;

    @Resource
    private CatelogService catelogService;

    @Resource
    private UserService userService;

    /**
     * 根据 闲置id查询该 闲置详细信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    // 定义请求处理方法：
    // 处理GET请求的方法
    @RequestMapping(value = "/detail/{id}")
    // 通过注解@RequestMapping指定了请求的路径
    // 方法的参数包括一个HttpSession对象、一个通过路径参数传递的id，以及一个可选的通过请求参数传递的str。
    public ModelAndView getGoodsById(HttpSession session, @PathVariable("id") Integer id, @RequestParam(value = "str", required = false) String str) throws Exception {
        Random random = new Random();
        User user = (User) session.getAttribute("cur_user");
        Wanted wanted = null;
        if (user != null) {
            wanted = wantedService.selectWant(user.getId(), id);
        }


        //五件闲置物品的集合
        List<Goods> commendGoods = new ArrayList<Goods>();
        //找出所有 闲置的id
        List<Goods> list = goodsService.selectPrimaryKey();
        // 这部分代码是方法的具体实现，用于处理业务逻辑。代码中首先获取当前用户的信息，然后根据用户id和闲置物品id查询Wanted对象。
        // 接下来，创建一个空的Goods列表（commendGoods）和一个列表（list），并调用相应的服务类方法来获取数据。
        //在接下来的代码中，通过循环和随机数选择算法，从list中选取五个闲置物品，将它们存储在commendGoods列表中。
        // 然后，使用commendGoods列表中的物品数据创建一个新的列表（commendExtends），并为每个物品查找相关的图片信息。
        //继续处理当前闲置物品的信息，包括更新浏览次数、查询关联的用户信息和分类信息，以及查询关联的图片信息。
        // 最后，将所有需要返回的数据添加到ModelAndView对象中，并设置视图的名称。

        for (int i = 0; i <= 5; i++) {
            Integer num = random.nextInt(list.size());
            Goods good = goodsService.selectByPrimaryKey(list.get(num).getId());
            commendGoods.add(good);
        }
        List<GoodsExtend> commendExtends = new ArrayList<GoodsExtend>();
        for (Goods good : commendGoods) {
            GoodsExtend commendExtend = new GoodsExtend();
            List<Image> imageList = imageService.selectByGoodsPrimaryKey(good.getId());
            commendExtend.setGoods(good);
            commendExtend.setImages(imageList);
            commendExtends.add(commendExtend);
        }

        //找出当前闲置
        Goods goodsFind = goodsService.selectByPrimaryKey(id);
        goodsService.updateViewCountByPrimaryKey(id, goodsFind.getViewcount() + 1);
        Goods goods = goodsService.selectByPrimaryKey(id);
        //找出当前 闲置的用户信息
        User seller = userService.selectByPrimaryKey(goods.getUserId());
        //找出分类信息
        Catelog catelog = catelogService.selectByPrimaryKey(goods.getCatelogId());
        //找到闲置对应的图片信息
        GoodsExtend goodsExtend = new GoodsExtend();
        List<Image> imageList = imageService.selectByGoodsPrimaryKey(id);
        goodsExtend.setGoods(goods);
        goodsExtend.setImages(imageList);
        //返回数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtend", goodsExtend);
        modelAndView.addObject("want", wanted);
        modelAndView.addObject("seller", seller);
        modelAndView.addObject("search", str);
        modelAndView.addObject("commend", commendExtends);
        modelAndView.addObject("catelog", catelog);
        modelAndView.setViewName("/detail/detail");
        // 方法的最后，返回ModelAndView对象，将数据和视图一起返回给客户端。
        return modelAndView;
    }

}
