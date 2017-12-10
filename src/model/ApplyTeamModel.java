package model;

public class ApplyTeamModel {
	
	public long teamid;
	
	public String userid;
	
	public String captainid;
	
	public ApplyTeamModel(long teamid, String userid, String captainid){
		this.teamid = teamid;
		this.userid = userid;
		this.captainid = captainid;
	}
	
	public long getTeamid(){
		return this.teamid;
	}
	
	public String getUserid(){
		return this.userid;
	}
	
	public String getCaptainid(){
		return this.captainid;
	}
	
	public void setCaptainid(String captainid){
		this.captainid = captainid;
	}
	
	public void setTeamid(long teamid){
		this.teamid = teamid;
	}
	
	public void setUserid(String userid){
		this.userid = userid;
	}

}
