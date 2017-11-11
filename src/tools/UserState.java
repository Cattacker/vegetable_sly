package tools;

import java.util.Map;
import java.util.Objects;

import com.opensymphony.xwork2.ActionContext;

public class UserState {
    
    private final Map session;
    
    public UserState() {
        session = ActionContext.getContext().getSession();
    }
    
    public boolean isManager() {
        return Objects.equals(session.get("user_id"), "root");
    }
    
    public boolean isVisitor() {
        return Objects.equals(session.get("user_id"), "tourist");
    }
    
    public boolean isMember() {
        if (session.containsKey("user_id"))
            return !(isVisitor() || isManager());
        else
            return false;
    }
}
