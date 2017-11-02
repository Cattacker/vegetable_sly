package mysql;



public class TravelPlan {
	private String ID;
	private String teamID;
	private long path;
	private String wishdate;
	
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
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getWishdate() {
		return wishdate;
	}
	public void setWishdate(String wishdate) {
		this.wishdate = wishdate;
	}

}
