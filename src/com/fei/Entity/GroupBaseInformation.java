package com.fei.Entity;

public class GroupBaseInformation {
	private int id;
	private String groupId;
	private String groupCount = "0";
	private String groupOwn;
	private String groupSummary = "小伙伴们，快来加群啊";
	private String groupHeadPortraitURL = "";
	private String groupName = "好人群";
	
	public GroupBaseInformation(){}

	public GroupBaseInformation(int id, String groupId, String groupCount, String groupOwn, String groupSummary,
			String groupHeadPortraitURL, String groupName) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupCount = groupCount;
		this.groupOwn = groupOwn;
		this.groupSummary = groupSummary;
		this.groupHeadPortraitURL = groupHeadPortraitURL;
		this.groupName = groupName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(String groupCount) {
		this.groupCount = groupCount;
	}

	public String getGroupOwn() {
		return groupOwn;
	}

	public void setGroupOwn(String groupOwn) {
		this.groupOwn = groupOwn;
	}

	public String getGroupSummary() {
		return groupSummary;
	}

	public void setGroupSummary(String groupSummary) {
		this.groupSummary = groupSummary;
	}

	public String getGroupHeadPortraitURL() {
		return groupHeadPortraitURL;
	}

	public void setGroupHeadPortraitURL(String groupHeadPortraitURL) {
		this.groupHeadPortraitURL = groupHeadPortraitURL;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
