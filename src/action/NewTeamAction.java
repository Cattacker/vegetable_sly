package action;

import com.opensymphony.xwork2.ActionSupport;

import action.personal.GetMyTravelPlanListAction;
import model.Plan;
import model.Team;

public class NewTeamAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;
    
    private long planId;
    
    private Plan plan;
    
    private GetMyTravelPlanListAction planList;
    
    public static final String CHOOSSEN = "choossen";
    
    public static final String COMPLETE = "complete";
    
    public String show() throws Exception {
        planList = new GetMyTravelPlanListAction();
        
        return planList.execute();
    }
    
    public String choosePlan() throws Exception {
        setPlan(Plan.getPlan(planId));
        return CHOOSSEN;
    }
    
    public String newTeam() throws Exception {
        Team team = new Team(name, planId, tools.UserState.getUsername());
        team.Teamsave();
        setPlan(Plan.getPlan(planId));
        plan.setTeamPlan();
        plan.save();
        return COMPLETE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public GetMyTravelPlanListAction getPlanList() {
        return planList;
    }

    public void setPlanList(GetMyTravelPlanListAction planList) {
        this.planList = planList;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    
    
}
