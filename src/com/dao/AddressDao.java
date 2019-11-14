package com.dao;

import java.util.List;

import com.pojo.Area;
import com.pojo.City;
import com.pojo.Province;

public interface AddressDao {
	
	public List<Province> getProvinces();
	public List<City> getCitesByProvince(String provinceCode);
	public List<Area> getAreasByCity(String cityCode);
	
}
