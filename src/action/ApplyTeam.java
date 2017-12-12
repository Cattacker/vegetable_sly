package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import mysql.UserRelation;
import model.*;

public class ApplyTeam extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long teamid;
	private String captainid;
	String follow = (String) ActionContext.getContext().getSession().get("user_ID");
	public boolean isInteam() {
		 MySQL my = new MySQL();
		 
		 ArrayList<TeamMember> teammembers=my.QueryTeammembers(teamid);
		 if(teammembers==null)
			 return false;
		 for(int i=0;i<teammembers.size();i++) {
			 String memberid=teammembers.get(i).member_id;
			 if(memberid.equals(follow))
				 return true;
		 }
		 return false;
	}
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String follow = (String) ActionContext.getContext().getSession().get("user_ID");
		 
			if(follow==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(follow!=null&&isInteam()==true) {
				this.addFieldError("error", "���Ѽ�����Ŷ�");
			}
			if(follow!=null&&isInteam()==false) {
				boolean r =  my.InsertApplyTeam(teamid, follow, captainid);
				this.addFieldError("error", "�ɹ���Ӻ���");
			}
	}
	public String execute(){
		return SUCCESS;
}
	public long getTeamid() {
		return teamid;
	}
	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}
	
	public String getCaptainid(){
		return this.captainid;
	}
	
	public void setCaptainid(String cid){
		this.captainid = cid;
	}
}
