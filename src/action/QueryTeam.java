package action;
import mysql.TravelPlan;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import model.Team;

public class QueryTeam extends ActionSupport{
	
	/**查询旅游计划
	 * 返回旅游计划列表
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Team> myteam= new ArrayList<Team>();
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "请您先登陆！");
			} 
			if(id!=null&&my.QueryMyTeam(id).isEmpty()) {
				this.addFieldError("error", "您还没有旅游计划！");
			}
	}
	
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setMyteam(my.QueryMyTeam(id));
		return SUCCESS;
	}
	public ArrayList<Team> getMyteam() {
		return myteam;
	}
	public void setMyteam(ArrayList<Team> myteam) {
		this.myteam = myteam;
	}
	
}
