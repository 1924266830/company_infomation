package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.pojo.Area;
import com.pojo.City;
import com.pojo.Province;
import com.servlet.JdbcUtils_C3P0;


public class AddressDaoImp implements AddressDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<Province> getProvinces() {
		// TODO Auto-generated method stub
		List<Province> provinces = new ArrayList<>();

		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from province";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
			
				Province province = new Province(id, code, name);
				
				provinces.add(province);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return provinces;
	}

	@Override
	public List<City> getCitesByProvince(String provinceCode) {
		// TODO Auto-generated method stub
		List<City> cities = new ArrayList<>();

		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from city where provincecode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, provinceCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String pcode = rs.getString("provincecode");
			
				City city = new City(id, code, name, pcode);
				
				cities.add(city);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return cities;
	}

	@Override
	public List<Area> getAreasByCity(String cityCode) {
		// TODO Auto-generated method stub
		List<Area> areas = new ArrayList<>();

		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from area where citycode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, cityCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String ccode = rs.getString("citycode");
			
				Area area = new Area(id, code, name, ccode);
				
				areas.add(area);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return areas;
	}
	public Province getProvinceBycode(String code)
	{	Province province = null;
		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from province where code='"+code+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");				
			String name = rs.getString("name");			
			province = new Province(id, code, name);
											
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return province;
	}
	public Area getAreaBycode(String code)
	{
			Area area = null;

		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from area where code = '"+code+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");				
			String name = rs.getString("name");			
			area = new Area(id, code, name,"");							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return area;
	}
	public City getCityBycode(String code) {
		// TODO Auto-generated method stub
		City city = null;

		conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from city where code = '"+code+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt("id");				
			String name = rs.getString("name");			
			city = new City(id, code, name,"");							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils_C3P0.release(conn, pstmt, rs);
		}

		return city;
	}


}
