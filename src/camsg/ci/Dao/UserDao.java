package camsg.ci.Dao;

import java.util.List;

import camsg.ci.entity.User;

public interface UserDao {
	User getUserbyusername(String username);
	void insert(User user);
	void update(User user);
	void delete(User user);
	List<User> getUserList();
	public User getUserbyID(int id);
	
}
