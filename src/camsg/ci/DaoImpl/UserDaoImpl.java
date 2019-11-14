package camsg.ci.DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import camsg.ci.Dao.UserDao;
import camsg.ci.entity.User;
import camsg.ci.utils.Packager;

public class UserDaoImpl extends JDBCBase implements UserDao{

	@Override
	public User getUserbyusername(String username) {
		// TODO Auto-generated method stub
		
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		String sql = "SELECT * FROM user where 1=1 and usename= '"+username+"'";
		try {
			
			ps = con.prepareStatement(sql);
			rs = query(ps);
			
			while(rs.next())
				user = Packager.packUser(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return user;
	}
	@Override
	public User getUserbyID(int id) {
		// TODO Auto-generated method stub
		
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		String sql = "SELECT * FROM user where 1=1 and id= "+id;
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			rs.next();
			user = Packager.packUser(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return user;
	}
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		String sql = "Insert into User(usename,password,email,phone,youbian,pic,place) VALUES(?,?,?,?,?,?,?)";
		Object[] param = {user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getYoubian(),user.getPic(),user.getPlace()};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		String sql = "delete from User where usename=?";
		Object[] param = {user.getUsername()};
		saveOrUpdateOrDelete(sql, param);
	}

	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> userlist=new ArrayList<User>();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user = null;
		String sql = "SELECT * FROM user ";
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			while(rs.next())
			{
				user = Packager.packUser(rs);
				userlist.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return userlist;
	}
	public void update(User user) {
		String sql = "update user set password='"+user.getPassword()+"', email='"+user.getEmail()+"',phone='"+user.getPhone()+"',youbian='"+user.getYoubian()+"', pic='"+user.getPic()+"' where usename='"+user.getUsername()+"'";
		//Object[] param = {user.getPassword(),user.getEmail(),user.getPhone(),user.getYoubian(),user.getPic(),user.getUsername()};
		saveOrUpdateOrDelete(sql,null);	
		
	}
}
