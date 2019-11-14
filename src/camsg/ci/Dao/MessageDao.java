package camsg.ci.Dao;

import java.util.List;

import camsg.ci.entity.Message;

public interface MessageDao {
	void sendMessage(String sender,String receiver,String content,String file);
	List<Message> acceptMessge(String receiver);
	void updatebyId(String id);
	Message getMessagebyId(String id);
}
