package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class LoginAction extends ActionSupport {

	/**登陆成功返回success
	 * 用户名密码错误返回login
	 * 数据格式错误返回error
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String none;

	public String execute(){
		if(true) {
			MySQL my = new MySQL();
			if(my.QueryBasic1(id, password)==true) {
				ActionContext.getContext().getSession().put("user_ID", id);
				ActionContext.getContext().getSession().put("user_password", password);
				return SUCCESS;//登陆成功
			}
			else//用户名密码错误
			{
				setNone("用户名密码错误！请重新输入");
				return LOGIN;
			}
		}
		setNone("数据格式输入有误！");
		return ERROR;//数据格式错误
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

	public String getNone() {
		return none;
	}

	public void setNone(String none) {
		this.none = none;
	}
	
}
