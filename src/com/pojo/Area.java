package com.pojo;

public class Area {
	private int id;
	private String code;
	private String name;
	private String cityCode;
		
	public Area() {
		super();
	}
	public Area(String code, String name, String cityCode) {
		super();
		this.code = code;
		this.name = name;
		this.cityCode = cityCode;
	}
	public Area(int id, String code, String name, String cityCode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.cityCode = cityCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", name=" + name + ", cityCode=" + cityCode + "]";
	}
	
}
