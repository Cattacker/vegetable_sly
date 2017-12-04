package action;
import mysql.TravelPlan;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import model.Team;

public class QueryTeam extends ActionSupport{
	
	/**��ѯ���μƻ�
	 * �������μƻ��б�
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> myteam= new ArrayList<Team>();
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(id!=null&&my.QueryMyTeam(id).isEmpty()) {
				this.addFieldError("error", "����û�����μƻ���");
			}
	}
	
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setMyteam(my.QueryMyTeam(id));
		System.out.println("QueryTeam");
		return SUCCESS;
	}
	public ArrayList<Team> getMyteam() {
		return myteam;
	}
	public void setMyteam(ArrayList<Team> myteam) {
		this.myteam = myteam;
	}
	
}
