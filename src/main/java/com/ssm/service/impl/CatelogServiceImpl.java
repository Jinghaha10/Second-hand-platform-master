package com.ssm.service.impl;

import com.ssm.dao.CatelogMapper;
import com.ssm.pojo.Catelog;
import com.ssm.service.CatelogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("catelogService")
public class CatelogServiceImpl implements CatelogService{

    @Resource
    private CatelogMapper catelogMapper;

    public int deleteByPrimaryKey(Integer id) {
        return catelogMapper.deleteByPrimaryKey(id);
    }

    public int insert(Catelog record) {
        return catelogMapper.insert(record);
    }

    public Catelog selectByPrimaryKey(Integer id) {
        return catelogMapper.selectByPrimaryKey(id);
    }

    public List<Catelog> selectAll() {
        return catelogMapper.selectAll();
    }

    public int updateByPrimaryKey(Catelog record) {
        return catelogMapper.updateByPrimaryKey(record);
    }

    public List<Catelog> getAllCatelogByStatus(Byte status) {
        return catelogMapper.getAllCatelogByStatus(status);
    }

    public int getCount(Catelog catelog) {
        return catelogMapper.getCount(catelog);
    }

    public int updateCatelogNum(Integer id, Integer number) {
        return catelogMapper.updateCatelogNum(id,number);
    }

    @Override
    public List<Catelog> searchCatelogByName(String name) {
        return catelogMapper.searchCatelogByName(name);
    }
}
