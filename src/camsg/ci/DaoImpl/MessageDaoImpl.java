package camsg.ci.DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import camsg.ci.Dao.MessageDao;
import camsg.ci.Dao.UserDao;
import camsg.ci.entity.Message;
import camsg.ci.entity.User;
import camsg.ci.utils.Packager;

public class MessageDaoImpl extends JDBCBase implements MessageDao{

	@Override
	public void sendMessage(String sender, String receiver, String content,String file) {
		// TODO Auto-generated method stub
		String sql = "Insert into Message(receiver,content,sender,isread,file) VALUES(?,?,?,?,?)";
		Object[] param = {receiver,content,sender,"0",file};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public List<Message> acceptMessge(String receiver) {
		// TODO Auto-generated method stub
		List<Message> messagelist=new ArrayList<Message>();
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Message Message = null;
		String sql = "SELECT * FROM Message where 1=1 and receiver='"+receiver+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			while(rs.next())
			{
				Message = Packager.packMessage(rs);
				messagelist.add(Message);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}

			return messagelist;
	}

	@Override
	public void updatebyId(String id) {
		// TODO Auto-generated method stub
		String sql="UPDATE message SET isread=1 WHERE idmessage=?";
		Object[] param = {id};
		saveOrUpdateOrDelete(sql, param);
	}

	@Override
	public Message getMessagebyId(String id) {
		// TODO Auto-generated method stub
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Message message = null;
		String sql = "SELECT * FROM message where 1=1 and idmessage= "+id;
		try {
			ps = con.prepareStatement(sql);
			rs = query(ps);
			rs.next();
			message = Packager.packMessage(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return message;
	}

	

}
