package mysql;

public class UserRelation {
	private String following_user_id;
	private String followed_user_id;
	public String getFollowed_user_id() {
		return followed_user_id;
	}
	public void setFollowed_user_id(String followed_user_id) {
		this.followed_user_id = followed_user_id;
	}
	public String getFollowing_user_id() {
		return following_user_id;
	}
	public void setFollowing_user_id(String following_user_id) {
		this.following_user_id = following_user_id;
	}
	
}
