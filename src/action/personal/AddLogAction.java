package action.personal;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class AddLogAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String text;

    private long planId;
    
    @Override
    public void validate() {
        if (text == null || text.trim().equals("") || text.length() > 120)
            addFieldError("text", "请输入日志信息且不多于120字");
    }
    
    @Override
    public String execute() throws Exception {
        if (tools.UserState.isMember() == false)
            return INPUT;
        Plan plan = Plan.getPlan(getPlanId());
        plan.addLog(text);
        return SUCCESS;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }
    
}
