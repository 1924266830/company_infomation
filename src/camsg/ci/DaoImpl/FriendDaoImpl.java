package camsg.ci.DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import camsg.ci.Dao.FriendDao;

import camsg.ci.entity.Friend;
import camsg.ci.utils.Packager;

public class FriendDaoImpl extends JDBCBase implements FriendDao{

	
	
	public Friend getFriendbyFriendname(String Friendname) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Friend friend = null;
		String sql = "SELECT * FROM friend where 1=1 and name= '"+Friendname+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			rs.next();
			friend = Packager.packFriend(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return friend;
		

	}
	
	public void insert(Friend friend) {
		// TODO Auto-generated method stub
		String sql = "Insert into friend(name,sex,phone,email,qq,youbian,username) VALUES('"+friend.getName()+"','"+friend.getSex()+"','"+friend.getPhone()+"','"+
				friend.getEmail()+"','"+friend.getQq()+"','"+friend.getYoubian()+"','"+friend.getUsername()+"')";
		Object[] param = {friend.getName(),friend.getSex(),friend.getPhone(),friend.getEmail(),friend.getQq(),friend.getYoubian(),friend.getUsername()};
		saveOrUpdateOrDelete(sql, null);
		
	}
	
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		String sql = "update friend set name=?,sex=?,phone=?,email=?,qq=?,youbian=?,username=? where name=? and username=?";
		Object[] param = {friend.getName(),friend.getSex(),friend.getPhone(),friend.getEmail(),friend.getQq(),
				friend.getYoubian(),friend.getUsername(),friend.getName(),friend.getUsername()};
		saveOrUpdateOrDelete(sql, param);
		
	}
	
	public void delete(Friend friend) {
		// TODO Auto-generated method stub
		String sql = "delete from friend where 1=1 and idfriend=?";
		Object[] param = {friend.getId()};
		saveOrUpdateOrDelete(sql, param);
		
	}
	
	public List<Friend> getFriendList(String username) {
		// TODO Auto-generated method stub
		List<Friend> friendlist=new ArrayList<Friend>();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Friend friend = null;
		String sql = "SELECT * FROM friend where 1=1 and username= '"+username+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			while(rs.next())
			{
				friend  = Packager.packFriend(rs);
				friendlist.add(friend);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return friendlist;
	}
	
	public Friend getFriendbyID(int id) {
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Friend friend = null;
		String sql = "SELECT * FROM friend where 1=1 and idfriend= "+id;
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			rs.next();
			friend = Packager.packFriend(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return friend;
	}
}
