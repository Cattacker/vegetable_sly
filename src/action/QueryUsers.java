package action;

import java.util.LinkedList;
import java.util.List;

import mysql.Basic;
import mysql.MySQL;
import com.opensymphony.xwork2.ActionSupport;

public class QueryUsers extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String[] keywords;
    
    private List<String> users;
    
    public void setKeywords(String text) {
        keywords = text.split(" ");
    }
    
    public String[] getKeywords() {
        return keywords;
    }
    
    public List<String> getUsers() {
        return users;
    }
    
    public String execute() throws Exception {
    	String id=keywords[0];
    	Basic temp=new MySQL().QueryBasic(id);
    	users.add("ID");
    	users.add(id);
    	users.add("NickName");
    	users.add(temp.getNickname());
    	users.add("Name");
    	users.add(temp.getName());
    	users.add("ComCity");
    	users.add(temp.getComcity());
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        super.validate();
        users = new LinkedList<String>();
        if (MySQL.isUserExist(keywords[0])==false)
            addFieldError("error", "用户不存在!");
    }
}
