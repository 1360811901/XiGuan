package com.fei.Entity;

public class GroupMemberList {
	private int id;
	private String userName;
	private String groupId;
	
	public GroupMemberList(){}

	public GroupMemberList(int id, String userName, String groupId) {
		super();
		this.id = id;
		this.userName = userName;
		this.groupId = groupId;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
