package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Team;
import mysql.MySQL;
import model.*;

public class QueryApplyTeam extends ActionSupport{
	
	/**ï¿½ï¿½Ñ¯ï¿½ï¿½ï¿½Î¼Æ»ï¿½
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Î¼Æ»ï¿½ï¿½Ð±ï¿½
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ApplyTeamModel> applyteams= new ArrayList<ApplyTeamModel>();
	private ArrayList<Invitations> invitations= new ArrayList<Invitations>();
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "ÇëÄúÏÈµÇÂ¼");
			} 
			if(id!=null&&my.QueryApplyTeams(id).isEmpty()&&my.QueryInvitations(id).isEmpty()) {
				this.addFieldError("error", "Ã»ÓÐÈëÍÅÉêÇë");
			}
	}
	
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setApplyteams(my.QueryApplyTeams(id));
		setInvitations(my.QueryInvitations(id));
		return SUCCESS;
	}
	public ArrayList<ApplyTeamModel> getApplyteams() {
		return this.applyteams;
	}
	public void setApplyteams(ArrayList<ApplyTeamModel> applyteams) {
		this.applyteams = applyteams;
	}
	public ArrayList<Invitations> getInvitations() {
		return this.invitations;
	}
	public void setInvitations(ArrayList<Invitations> invitations) {
		this.invitations = invitations;
	}
	
}

