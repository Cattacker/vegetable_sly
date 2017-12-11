package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class InviteFriends extends ActionSupport {

	/**�鿴����
	 * ���غ����б�
	 */
	private long teamid;
	private static final long serialVersionUID = 1L;
	private ArrayList<String> friends= new ArrayList<String>();
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(id!=null&&my.QueryUserRelation(id).isEmpty()) {
				this.addFieldError("error", "����û�к��ѣ�");
			}
	}
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setFriends(my.QueryUserRelation(id));
		return SUCCESS;
	}
	public ArrayList<String> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}
	public long getTeamid() {
		return teamid;
	}
	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}
}
