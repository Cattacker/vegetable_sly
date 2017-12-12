package action.personal;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class GetMyTravelPlanAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final String SHOW = "show";
    
    private Plan plan;
    
    private long planId;
    
    @Override
    public String execute() throws Exception {
        if (tools.UserState.isMember() == false)
            return LOGIN;
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
    
    public String getTravelState() {
        if (plan.isUnstart())
            return "待执行";
        else if (plan.isRated())
            return "已评价";
        else if (plan.isOver())
            return "未评价";
        else
            return "进行中";
    }
}
