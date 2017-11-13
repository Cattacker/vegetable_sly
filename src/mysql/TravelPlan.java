package mysql;



public class TravelPlan {
	private String ID;
	private long  teamID;
	private long path;
	private String wishdate;
	private int state;
	
	
	public TravelPlan(String id, long teamid, long path, String wishdate,int state){
		this.ID = id;
		this.teamID = teamid;
		this.path = path;
		this.wishdate = wishdate;
		this.state = state;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public long getPath() {
		return path;
	}
	public void setPath(long path) {
		this.path = path;
	}
	public long getTeamID() {
		return teamID;
	}
	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}
	public String getWishdate() {
		return wishdate;
	}
	public void setWishdate(String wishdate) {
		this.wishdate = wishdate;
	}
	public int getState(){
		return this.state;
	}
	public void setState(int state){
		this.state = state;
	}

}
