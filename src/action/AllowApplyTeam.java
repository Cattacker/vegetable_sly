package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.ApplyTeamModel;
import model.Plan;
import mysql.MySQL;

public class AllowApplyTeam extends ActionSupport{
	
	/**ï¿½ï¿½Ñ¯ï¿½ï¿½ï¿½Î¼Æ»ï¿½
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Î¼Æ»ï¿½ï¿½Ð±ï¿½
	 */
	private static final long serialVersionUID = 1L;
	
	private long teamid;
	
	private String userid;
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "ÇëÄúÏÈµÇÂ¼");
			} 
	}
	
	public String execute(){
		MySQL my = new MySQL();
		my.AllowApplyTeams(teamid, userid);
		Plan.newRelatedPlan(teamid, userid);
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

