package action;

import java.util.LinkedList;
import java.util.List;
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
        users = new LinkedList<String>();
        for (String id : keywords)
            if (MySQL.isUserExist(id))
                users.add(id);
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        super.validate();
        if (keywords.length == 0)
            addFieldError("keywords", "请输入关键字!");
    }
}
