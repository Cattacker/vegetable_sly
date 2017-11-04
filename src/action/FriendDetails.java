package action;

import com.opensymphony.xwork2.ActionSupport;
import mysql.MySQL;
import mysql.Basic;
public class FriendDetails extends ActionSupport {

	/**查询好友详细信息
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nickname;
	private String name;
	private String comcity;
	private String phonenum;
	private int sex;
	private String birthday;
	
	public String execute(){
		 Basic temp=new MySQL().QueryBasic(id);
		 setNickname(temp.getNickname());
		 setName(temp.getName());
		 setComcity(temp.getComcity());
		 setPhonenum(temp.getPhonenum());
		 setSex(temp.isSex());
		 setBirthday(temp.getBirthday().toString());
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
