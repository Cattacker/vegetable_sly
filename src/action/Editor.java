package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import mysql.MySQL;
import mysql.Stratety;
public class Editor extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String editor1;
	
	public String execute() {
		editor1=ServletActionContext.getRequest().getParameter("editor1");
		Stratety temp=new Stratety();
		temp.setEditor(editor1);
		new MySQL().InsertStratety(temp);
		return SUCCESS;
	}
}
