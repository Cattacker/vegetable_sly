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
		 System.out.println(teamid);
 		 System.out.println(follow);
		 System.out.println(captainid);
		 String follow = (String) ActionContext.getContext().getSession().get("user_ID");
		 
			if(follow==null) {
				this.addFieldError("error", "请您先登陆！");
			} 
			if(follow!=null&&isInteam()==true) {
				this.addFieldError("error", "您已加入该团队");
			}
			if(follow!=null&&isInteam()==false) {
				boolean r =  my.InsertApplyTeam(teamid, follow, captainid);
				this.addFieldError("error", "成功添加好友");
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
