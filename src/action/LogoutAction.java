package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**注销成功返回success
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute() {
		ActionContext ac = ActionContext.getContext(); 
		Map session = ac.getSession(); 
		session.remove("user_ID");
		session.remove("user_password");
		return SUCCESS;
	}
	
}
