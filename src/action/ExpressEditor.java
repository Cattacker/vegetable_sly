package action;

import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import mysql.Stratety;
public class ExpressEditor extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text1;
	private String text2;
	private String text3;
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String execute() {
		text1=new MySQL().QueryStratety(1).getEditor();
		text2=new MySQL().QueryStratety(2).getEditor();
		text3=new MySQL().QueryStratety(3).getEditor();
		return SUCCESS;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
}
