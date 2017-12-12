package model;

public class Invitations {
	
	public long teamid;
	
	public String friendid;
	
	
	public Invitations(long teamid, String friendid){
		this.teamid = teamid;
		this.friendid = friendid;
	}
	
	public long getTeamid(){
		return this.teamid;
	}
	
	public String getFriendid(){
		return this.friendid;
	}
	
	public void setTeamid(long teamid){
		this.teamid = teamid;
	}
	
	public void setUserid(String friendid){
		this.friendid = friendid;
	}

}
