package tools;

import java.util.Map;
import java.util.Objects;

import com.opensymphony.xwork2.ActionContext;

public class UserState {
    
    public static boolean isManager() {
        Map session = ActionContext.getContext().getSession();
        return Objects.equals(session.get("user_ID"), "root");
    }
    
    public static boolean isVisitor() {
        Map session = ActionContext.getContext().getSession();
        return session.containsKey("user_ID") == false;
    }
    
    public static boolean isMember() {
        return !(isVisitor() || isManager());
    }
    
    public static String getUsername() {
        Map session = ActionContext.getContext().getSession();
        return (String) session.get("user_ID");
    }
}
