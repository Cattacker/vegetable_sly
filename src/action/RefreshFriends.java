package action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;
import mysql.Basic;
import mysql.MySQL;

public class RefreshFriends extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String nickname;
	private String name;
	private String sex;
	private String comcity;
	private String phonenum;
	public String execute(){
		Basic temp = new Basic();
		id=tools.UserState.getUsername();
		temp.setID(id);
		temp.setPassword(password);
		temp.setNickname(nickname);
		temp.setName(name);
		//SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " ); 
		if(Integer.valueOf(sex)==0)
			temp.setSex(false);
		else
			temp.setSex(true);
		temp.setComcity(comcity);
		temp.setPhonenum(phonenum);
		new MySQL().UpdateBasic(temp);
		return SUCCESS;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String isSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getComcity() {
		return comcity;
	}
	public void setComcity(String comcity) {
		this.comcity = comcity;
	}
	
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	} 
		
}
