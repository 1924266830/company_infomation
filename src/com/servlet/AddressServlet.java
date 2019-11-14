package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dao.AddressDao;
import com.dao.AddressDaoImp;
import com.pojo.Area;
import com.pojo.City;
import com.pojo.Province;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AddressDao addressDao = new AddressDaoImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if (null != method && !"".equals(method))
		{
			if ("initProvince".equals(method))
			{
				initProvince(request, response);
			} else if ("getCity".equals(method))
			{
				getCity(request, response);
			}else if("getArea".equals(method)) {
				getArea(request,response);
			}
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void getArea(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		String cityCode = req.getParameter("cityCode");
		List<Area> areaList = addressDao.getAreasByCity(cityCode);
		
		String jsonStr = JSON.toJSONString(areaList);
		System.out.println(jsonStr);
		
		resp.getWriter().write(jsonStr);
		
	}

	private void getCity(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		String provCode = req.getParameter("provCode");
		//System.out.println(provCode);
		List<City> cityList = addressDao.getCitesByProvince(provCode);
		
		String jsonStr = JSON.toJSONString(cityList);
		resp.getWriter().write(jsonStr);
	}

	private void initProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		List<Province> provList = addressDao.getProvinces();
		
		String jsonStr = JSON.toJSONString(provList);
		//System.out.println(jsonStr);
		resp.getWriter().write(jsonStr);
		
	}


}
