package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;

public class LoginAction extends ActionSupport {

	/**��½�ɹ�����success
	 * �û���������󷵻�login
	 * ���ݸ�ʽ���󷵻�error
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
				return SUCCESS;//��½�ɹ�
			}
			else//�û����������
			{
				setNone("�û��������������������");
				return LOGIN;
			}
		}
		setNone("���ݸ�ʽ��������");
		return ERROR;//���ݸ�ʽ����
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
