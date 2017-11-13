package action;
import mysql.TravelPlan;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class QueryTravelPlan extends ActionSupport{
	
	/**��ѯ���μƻ�
	 * �������μƻ��б�
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TravelPlan> travelplan= new ArrayList<TravelPlan>();
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String id = (String) ActionContext.getContext().getSession().get("user_ID");
			if(id==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(id!=null&&my.QueryTravelPlan(id).isEmpty()) {
				this.addFieldError("error", "����û�����μƻ���");
			}
	}
	public String execute(){
		MySQL my = new MySQL();
		String id = (String) ActionContext.getContext().getSession().get("user_ID");
		setTravelplan(my.QueryTravelPlan(id));
		return SUCCESS;
	}
	public ArrayList<TravelPlan> getTravelplan() {
		return travelplan;
	}
	public void setTravelplan(ArrayList<TravelPlan> travelplan) {
		this.travelplan = travelplan;
	}
	
}
