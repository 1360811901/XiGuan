package com.fei.garbage;

public class UserFriend {
	private int id;
	private String userName;
	private String friendName;
	private String fstate;
	
	public UserFriend(){}
	
	public UserFriend(String user,String friend,String fstate){
		this.userName = user;
		this.friendName = friend;
		this.fstate = fstate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFstate() {
		return fstate;
	}

	public void setFstate(String fstate) {
		this.fstate = fstate;
	}
	
	

}
