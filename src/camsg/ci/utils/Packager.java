package camsg.ci.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import camsg.ci.entity.Friend;
import camsg.ci.entity.Message;
import camsg.ci.entity.User;


public class Packager {


	
	/**
	 * 封装User的普通属性，不包含City属性
	 */
	public static User packUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setUsername(rs.getString("usename"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));				
		user.setEmail(rs.getString("email"));
		user.setYoubian(rs.getString("youbian"));
		user.setPic(rs.getString("pic"));
		user.setPlace(rs.getString("place"));
		return user;
	}

	public static Message packMessage(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		Message message=new Message();
		message.setId(rs.getString("idmessage"));
		message.setReceiver(rs.getString("receiver"));
		message.setContent(rs.getString("content"));
		message.setSender(rs.getString("sender"));
		message.setIsread(rs.getString("isread"));
		message.setFile(rs.getString("file"));
		return message;
	}
	
	public static Friend packFriend(ResultSet rs) throws SQLException {
		Friend friend = new Friend();
		friend.setId(rs.getString("idfriend"));
		friend.setName(rs.getString("name"));
		friend.setSex(rs.getString("sex"));
		friend.setPhone(rs.getString("phone"));
		friend.setEmail(rs.getString("email"));
		friend.setQq(rs.getString("qq"));
		friend.setYoubian(rs.getString("youbian"));
		friend.setUsername(rs.getString("username"));
		return friend;
	}

	
}
