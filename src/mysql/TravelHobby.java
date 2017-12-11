package mysql;

public class TravelHobby {
	
	public String id;
	
	public String[] checkbox;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getCheckbox() {
		return this.checkbox;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
	
	public TravelHobby(String id, String[] checkbox){
		this.id = id;
		this.checkbox = checkbox;
	}

}
