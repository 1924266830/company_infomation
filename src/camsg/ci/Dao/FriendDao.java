package camsg.ci.Dao;

import java.util.List;

import camsg.ci.entity.Friend;


public interface FriendDao {
	Friend getFriendbyFriendname(String Friendname);
	void insert(Friend Friend);
	void update(Friend Friend);
	void delete(Friend Friend);
	List<Friend> getFriendList(String username);
	public Friend getFriendbyID(int id);
}
