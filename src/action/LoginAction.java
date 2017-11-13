package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class LoginAction extends ActionSupport {

	/**��½�ɹ�����success
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	
	
	public void validate() {
		 super.validate();
	       
	     MySQL my = new MySQL();
	     if(my.QueryBasic1(id, password)==false)  {
	    	 this.addFieldError("error", "�û��������������������");
	     }
	}
	public String execute(){
			ActionContext.getContext().getSession().put("user_ID", id);
			ActionContext.getContext().getSession().put("user_password", password);
			return SUCCESS;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
