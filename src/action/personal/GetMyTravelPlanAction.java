package action.personal;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class GetMyTravelPlanAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Plan plan;
    
    private long planId;
    
    @Override
    public String execute() throws Exception {
        plan = Plan.getPlan(planId);
        return SUCCESS;
    }
    
    public Plan getPlan() {
        return plan;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }
}
