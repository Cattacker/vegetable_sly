package action;


import com.opensymphony.xwork2.ActionSupport;

import mysql.*;

public class RegAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private String nickname;
	private String repassword;
	private String none;

	public String execute(){
		if(true) {
			
			if(password.equals(repassword)) {
				Basic temp = new Basic();
				temp.setID(id);temp.setPassword(password);temp.setNickname(nickname);
				new MySQL().InsertBasic(temp);
				return SUCCESS;//注册成功
			}
			else//两次密码不一致
			{
				setNone("两次密码不一致！请重新输入");
				return LOGIN;
			}
		}
		setNone("数据格式输入有误！");
		return ERROR;//数据格式错误
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNone() {
		return none;
	}

	public void setNone(String none) {
		this.none = none;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
