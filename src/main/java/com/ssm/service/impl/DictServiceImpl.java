package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ssm.dao.DictMapper;
import com.ssm.pojo.Area;
import com.ssm.pojo.City;
import com.ssm.pojo.Province;
import org.springframework.stereotype.Service;

@Service("dictService")
public class DictServiceImpl implements com.ssm.service.DictService {

	@Resource
	private DictMapper dictMapper;

	@Override
	public List<Province> getProvinces() {
		return dictMapper.getProvinces();
	}
	@Override
	public List<City> getCities(String provinceCode) {
		return dictMapper.getCities(provinceCode);
	}
	@Override
	public List<Area> getAreas(String cityCode) {
		return dictMapper.getAreas(cityCode);
	}

}
