package action;

import com.opensymphony.xwork2.ActionSupport;
import mysql.MySQL;
public class DeleteFriend extends ActionSupport {

	/**ɾ������
	 * ɾ���ɹ���ת�ظ�����ҳ
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	
	public String execute(){
		new MySQL().DeleteUserRelation(id);
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
