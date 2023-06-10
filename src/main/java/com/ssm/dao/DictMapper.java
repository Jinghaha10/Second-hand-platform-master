package com.ssm.dao;

import java.util.List;

import com.ssm.pojo.Area;
import com.ssm.pojo.City;
import com.ssm.pojo.Province;

public interface DictMapper {

	List<Province> getProvinces();
	List<City> getCities(String provinceCode);
	List<Area> getAreas(String cityCode);
	String  getProvinceByCode(String code);
	String  getCityByCode(String code);
	String  getAreaByCode(String code);
}









