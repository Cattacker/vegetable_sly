package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.TeamMember;
import mysql.MySQL;

public class InviteRelation extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long teamid;
	private String friendid;
	String follow = (String) ActionContext.getContext().getSession().get("user_ID");
	public boolean isInteam() {
		 MySQL my = new MySQL();
		 
		 ArrayList<TeamMember> teammembers=my.QueryTeammembers(teamid);
		 if(teammembers==null)
			 return false;
		 for(int i=0;i<teammembers.size();i++) {
			 String memberid=teammembers.get(i).member_id;
			 if(memberid.equals(friendid))
				 return true;
		 }
		 return false;
	}
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String follow = (String) ActionContext.getContext().getSession().get("user_ID");
		 
			if(follow==null) {
				this.addFieldError("error", "请您先登陆！");
			} 
			if(follow!=null&&isInteam()==true) {
				this.addFieldError("error", "您已加入该团队");
			}
			if(follow!=null&&isInteam()==false) {
				boolean w = my.InsertInvite(teamid, friendid);
				this.addFieldError("error", "成功发出邀请");
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
	
	public String getFriendid(){
		return this.friendid;
	}
	
	public void setFriendid(String cid){
		this.friendid = cid;
	}
}