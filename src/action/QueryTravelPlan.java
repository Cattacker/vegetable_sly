package action;
import mysql.TravelPlan;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class QueryTravelPlan extends ActionSupport{
	
	/**查询旅游计划
	 * 返回旅游计划列表
	 */
	public int state = 0;
	private static final long serialVersionUID = 1L;
	private ArrayList<TravelPlan> travelplan= new ArrayList<TravelPlan>();
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "请您先登陆！");
			} 
			if(id!=null&&my.QueryTravelPlan(id,state).isEmpty()) {
				this.addFieldError("error", "您还没有旅游计划！");
			}
	}
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setTravelplan(my.QueryTravelPlan(id,state));
		return SUCCESS;
	}
	public ArrayList<TravelPlan> getTravelplan() {
		return travelplan;
	}
	public void setTravelplan(ArrayList<TravelPlan> travelplan) {
		this.travelplan = travelplan;
	}
	public int getState(){
		return this.state;
	}
	public void setState(int state){
		this.state = state;
	}
	
}
