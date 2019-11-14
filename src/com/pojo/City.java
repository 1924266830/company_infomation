package com.pojo;

public class City {
	private int id;
	private String code;
	private String name;
	private String provinceCode;
			
	public City() {
		super();
	}
	public City(String code, String name, String provinceCode) {
		super();
		this.code = code;
		this.name = name;
		this.provinceCode = provinceCode;
	}
	public City(int id, String code, String name, String provinceCode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.provinceCode = provinceCode;
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
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + ", provinceCode=" + provinceCode + "]";
	}
	
}
