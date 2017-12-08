package action;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mysql.Basic;
import mysql.MySQL;
import com.opensymphony.xwork2.ActionSupport;
import model.*;

public class QueryTeams extends ActionSupport {
	
private static final long serialVersionUID = 1L;
    
    private String keywords;
    
    private long teamid;
    
    private ArrayList<Team> teams;
    
    public void setKeywords(String text) {
        keywords = text.trim();
    }
    
    public String getKeywords() {
        return keywords;
    }
    
    public ArrayList<Team> getTeams() {
        return teams;
    }
    
    public String execute() throws Exception {
    	if(keywords == null){
    		System.out.println("are you ok?");
    	}
    	else{
    		System.out.println("i am ok");
    	}
    	teamid = Long.parseLong(keywords);
    	System.out.println(teamid);
    	teams=new MySQL().QueryTeamsByIdOrName(teamid,keywords);
    	System.out.println(teams.size());
        return SUCCESS;
    }
    

}
