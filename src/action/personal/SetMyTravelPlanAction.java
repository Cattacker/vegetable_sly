package action.personal;

import com.opensymphony.xwork2.ActionSupport;

public class SetMyTravelPlanAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private long planId;

    public String show() throws Exception {
        return SUCCESS;
    }
    
    public String set() throws Exception {
        return SUCCESS;
    }
    
    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }
}
