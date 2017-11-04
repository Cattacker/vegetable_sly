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

	public void validate() {
		 super.validate();
	       
	     MySQL my = new MySQL();
	     if(password.equals(repassword)==false)  {
	    	 this.addFieldError("error", "两次密码不一致！请重新输入");
	     }
	     else if(my.QueryBasic2(id)) {
	    	 this.addFieldError("error", "该ID已被注册！请重新输入");
	     }
	}
	public String execute(){
			Basic temp = new Basic();
			temp.setID(id);temp.setPassword(password);temp.setNickname(nickname);
			new MySQL().InsertBasic(temp);
			return SUCCESS;//注册成功
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
