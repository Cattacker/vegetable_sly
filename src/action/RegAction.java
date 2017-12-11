package action;


import com.opensymphony.xwork2.ActionSupport;

import mysql.*;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

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
	HttpServletRequest request = ServletActionContext.getRequest();
	public void validate() {
		 super.validate();
	       
	     MySQL my = new MySQL();
	     if(password.equals(repassword)==false)  {
	    	 this.addFieldError("error", "�������벻һ�£�����������");
	     }
	     else if(my.QueryBasic2(id)) {
	    	 this.addFieldError("error", "��ID�ѱ�ע�ᣡ����������");
	     }
	}
	public String execute() throws UnsupportedEncodingException{
			request.setCharacterEncoding("gbk");  
			String[] checkbox= request.getParameterValues("type"); //�������ֻ��checkbox��ֵ��ע����getParameters������Ҫ����s����Ϊ��һ������  
			Basic temp = new Basic();
			TravelHobby tmp = new TravelHobby(id, checkbox);
			temp.setID(id);temp.setPassword(password);temp.setNickname(nickname);
			boolean q = new MySQL().InsertTravelHobby(tmp);
			new MySQL().InsertBasic(temp);
			return SUCCESS;//ע��ɹ�
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
