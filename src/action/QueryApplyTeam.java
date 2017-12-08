package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Team;
import mysql.MySQL;
import model.*;

public class QueryApplyTeam extends ActionSupport{
	
	/**��ѯ���μƻ�
	 * �������μƻ��б�
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ApplyTeamModel> applyteams= new ArrayList<ApplyTeamModel>();
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(id!=null&&my.QueryApplyTeams(id).isEmpty()) {
				this.addFieldError("error", "����û����Ϣ��");
			}
	}
	
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setApplyteams(my.QueryApplyTeams(id));
		System.out.println("QueryTeam");
		return SUCCESS;
	}
	public ArrayList<ApplyTeamModel> getApplyteams() {
		return this.applyteams;
	}
	public void setApplyteams(ArrayList<ApplyTeamModel> applyteams) {
		this.applyteams = applyteams;
	}
	
}

