package action.personal;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class GetMyTravelPlanListAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private List<Plan> plans;
    
    @Override
    public String execute() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        return SUCCESS;
    }
    
    public List<Plan> getPlans() {
        return plans;
    }
    
}
