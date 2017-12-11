package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import mysql.Stratety;
public class ExpressEditor extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text1;
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String execute() {
		text1=new MySQL().QueryStratety(2).getEditor();
		return SUCCESS;
	}
}
