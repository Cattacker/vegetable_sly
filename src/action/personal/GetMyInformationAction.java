package action.personal;

import model.User;
import tools.UserState;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GetMyInformationAction extends ActionSupport {
    
    User user;
    
    public User getUser() {
        return user;
    }
    
    public String execute() throws Exception {
        if (UserState.isVisitor())
            return LOGIN;
        else {
            user = User.getUser();
            return SUCCESS;
        }
    }
    
}
