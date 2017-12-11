package action.personal;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class RatePathAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private long planId;
    
    private Integer rate;
    
    @Override
    public void validate() {
        if (rate == null || rate > 5 || rate < 0)
            addFieldError("rate", "请选择0~5内的评分!");
    }

    @Override
    public String execute() throws Exception {
        if (tools.UserState.isMember() == false)
            return LOGIN;
        Plan plan = Plan.getPlan(planId);
        plan.rate(rate);
        return SUCCESS;
    }
    
    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    
}
