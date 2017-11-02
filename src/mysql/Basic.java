package mysql;

import java.sql.Date;

public class Basic {
	private String ID;
	private String password;
	private String nickname;
	private String name;
	private boolean sex;
	private String comcity;
	private Date birthday;
	private String phonenum;
	public Basic() {
		ID=null;password=null;nickname=null;name=null;sex=false;comcity=null;birthday=null;phonenum=null;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public int isSex() {
		if(sex==true)
			return 1;
		else
			return 0;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getComcity() {
		return comcity;
	}
	public void setComcity(String comcity) {
		this.comcity = comcity;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	
}
