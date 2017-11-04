package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import mysql.MySQL;
import mysql.UserRelation;

public class AddFriends extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String followed;
	
	public void validate() {
		 super.validate();
		 MySQL my = new MySQL();
		 String follow = (String) ActionContext.getContext().getSession().get("user_ID");
			if(follow==null) {
				this.addFieldError("error", "�����ȵ�½��");
			} 
			if(follow!=null&&my.QueryUserRelation(follow).isEmpty()==false) {
				this.addFieldError("error", "������ӹ��ú���");
			}
			if(follow!=null&&my.QueryUserRelation(follow).isEmpty()) {
				UserRelation temp=new UserRelation();
				temp.setFollowing_user_id(follow);
				temp.setFollowed_user_id(followed);
				my.InsertUserRelation(temp);
				this.addFieldError("error", "�ɹ���Ӻ���");
			}
	}
	public String execute(){
		return SUCCESS;
}
	public String getFollowed() {
		return followed;
	}
	public void setFollowed(String followed) {
		this.followed = followed;
	}
}
