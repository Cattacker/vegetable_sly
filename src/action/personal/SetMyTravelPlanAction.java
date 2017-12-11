package action.personal;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class SetMyTravelPlanAction extends ActionSupport {

    /**
     * 
     */
    public static final String SHOW = "show";
    
    public static final String STRICT_SHOW = "strict_show";
    
    private static final long serialVersionUID = 1L;

    private long planId;
    
    private Plan plan;

    private String newName;
    
    private Date newBeginningDate;
    
    private String newLocation;
    
    private int locationIndex;
    
    public void validate() {
        if (getNewBeginningDate() != null)
            if (getNewBeginningDate().getTime() < (new java.util.Date()).getTime())
                addFieldError("newBeginningDate", "请填写正确的日期");
        if (getNewName() != null)
            if (getNewName().trim().equals("") || getNewName().length() > 50)
                addFieldError("newName", "计划名不能为空, 且不多于50个字符");
        if (getNewLocation() != null)
            if (getNewLocation().trim().equals(""))
                addFieldError("newLocation", "请输入地址");
    }
    
    public String show() throws Exception {
        setPlan(Plan.getPlan(planId));
        System.out.println(getPlan().getPath().getText());
        if (plan.isUnstart() == false)
            return ERROR;
        return SHOW;
    }
    
    public String changeName() throws Exception {
        setPlan(Plan.getPlan(planId));
        if (plan.isUnstart() == false)
            return ERROR;
        plan.changeName(newName);
        plan.save();
        return SUCCESS;
    }
    
    public String globalChangeName() throws Exception {
        setPlan(Plan.getPlan(planId));
        plan.changeName(newName);
        plan.save();
        return STRICT_SHOW;
    }
    
    public String changeBeginningDate() throws Exception {
        setPlan(Plan.getPlan(planId));
        if (plan.changeBeginningDate(newBeginningDate) == false)
            return ERROR;
        plan.save();
        return SUCCESS;
    }
    
    public String newLocation() throws Exception {
        setPlan(Plan.getPlan(planId));
        if (plan.add(locationIndex, newLocation) == false)
            return ERROR;
        plan.save();
        return SUCCESS;
    }
    
    public String deleteLocation() throws Exception {
        setPlan(Plan.getPlan(planId));
        plan.remove(locationIndex);
        plan.save();
        return SUCCESS;
    }
    
    public String over() throws Exception {
        if (tools.UserState.isMember() == false)
            return LOGIN;
        setPlan(Plan.getPlan(planId));
        plan.over();
        return SUCCESS;
    }
    
    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Date getNewBeginningDate() {
        return newBeginningDate;
    }

    public void setNewBeginningDate(Date newBeginningDate) {
        this.newBeginningDate = newBeginningDate;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

}
