package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class AllowInvitation extends ActionSupport{
	
	/**查询旅游计划
	 * 返回旅游计划列表
	 */
	private static final long serialVersionUID = 1L;
	
	private long teamid;
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "请您先登陆！");
			} 
	}
	
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		my.AllowInvitations(teamid, id);
		return SUCCESS;
	}
	public void setTeamid(long teamid){
		this.teamid = teamid;
	}
	
	public long getTeamid(){
		return this.teamid;
	}
}