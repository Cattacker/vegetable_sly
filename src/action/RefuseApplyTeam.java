package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class RefuseApplyTeam extends ActionSupport{
	
	/**��ѯ���μƻ�
	 * �������μƻ��б�
	 */
	private static final long serialVersionUID = 1L;
	
	private long teamid;
	
	private String userid;
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
	}
	
	public String execute(){
		MySQL my = new MySQL();
		my.RefuseApplyTeams(teamid, userid);
		return SUCCESS;
	}
	public void setTeamid(long teamid){
		this.teamid = teamid;
	}
	
	public long getTeamid(){
		return this.teamid;
	}
	
	public void setUserid(String userid){
		this.userid = userid;
	}
	
	public String getUserid(){
		return this.userid;
	}
}

