package action.personal;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import tools.UserState;

@SuppressWarnings("serial")
public class SetMyInformationAction extends ActionSupport {
    
    private User user;
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
    
    public String commit() throws Exception {
        if (user != null && user.equalsOnId(User.getUser())) {
            User.updateUser(user);
            return SUCCESS;
        } else {
            return LOGIN;
        }
    }
    
    public String getView() throws Exception {
        if (UserState.isVisitor())
            return LOGIN;
        else {
            user = User.getUser();
            return "getView";
        }
    }
    
}
