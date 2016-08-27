package com.fei.garbage;

public class User {
	private int id;
	private String userId;
	private String userName;
	// ����ĳ���Ϊ9 λ
	private String passWord;
	private String question;
	private String answer;
	
	// Hibernate �־û�������Ҫ�޲ι���
	public User(){}
	
	public User(String userId,String userName,String passWord){
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}
	
	/** hibernate ���Ե��ô˷�����Ϊid ��ֵ����ҵ���߼����޷����ʴ˷���
	 * ���԰�setId �ķ���Ȩ����Ϊprivate
	 *  */
	
	private void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
}
