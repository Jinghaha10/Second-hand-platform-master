package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Area;
import com.ssm.pojo.City;
import com.ssm.pojo.Province;

public interface DictService {
	List<Province> getProvinces();
	List<City> getCities(String provinceCode);
	List<Area> getAreas(String cityCode);

}







