package camsg.ci.entity;

public class Message {
	String id="";
	String receiver="";
	String content="";
	String sender="";
	String isread="0";
	String file="";
	
	
	public Message(String id, String receiver, String content, String sender, String isread,String file) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.content = content;
		this.sender = sender;
		this.isread = isread;
		this.file=file;
	}
	
	
	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public Message() {
		super();
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	
}
