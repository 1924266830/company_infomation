package com.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils_C3P0 {
	   private static ComboPooledDataSource ds = null;
	   //�ھ�̬������д������ݿ����ӳ�
	   static{
	       try{	           
	           //ͨ����ȡC3P0��xml�����ļ���������Դ��C3P0��xml�����ļ�c3p0-config.xml�������srcĿ¼��
	           ds = new ComboPooledDataSource();//ʹ��C3P0��Ĭ����������������Դ          
	       }catch (Exception e) {
	           throw new ExceptionInInitializerError(e);
	       }
	   }
	   
	   /**
	   * @Method: getConnection
	   * @Description: ������Դ�л�ȡ���ݿ�����
	   * @Anthor:
	   * @return Connection
	   * @throws SQLException
	   */ 
	   public static Connection getConnection() {
	       //������Դ�л�ȡ���ݿ�����
	       Connection conn = null;
		   try {
			 conn= ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return conn;
	   }
	   
	   /**
	   * @Method: release
	   * @Description: �ͷ���Դ��
	   * �ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement���󣬴洢��ѯ�����ResultSet����
	   * @Anthor:
	   *
	   * @param conn
	   * @param st
	   * @param rs
	   */ 
	   public static void release(Connection conn, PreparedStatement st,ResultSet rs){
	       if(rs!=null){
	           try{
	               //�رմ洢��ѯ�����ResultSet����
	               rs.close();
	           }catch (Exception e) {
	               e.printStackTrace();
	           }
	           rs = null;
	       }
	       if(st!=null){
	           try{
	               //�رո���ִ��SQL�����Statement����
	               st.close();
	           }catch (Exception e) {
	               e.printStackTrace();
	           }
	       }
	       
	       if(conn!=null){
	           try{
	               //��Connection���Ӷ��󻹸����ݿ����ӳ�
	               conn.close();
	           }catch (Exception e) {
	               e.printStackTrace();
	           }
	       }
	   }

}
