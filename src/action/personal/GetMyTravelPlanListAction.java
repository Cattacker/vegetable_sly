package action.personal;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Plan;

public class GetMyTravelPlanListAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final String UNSTART = "unstart";

    private static final String TRAVELING = "traveling";

    private static final String OVER = "over";

    private static final String RATED = "rated";
    
    private List<Plan> plans;
    
    private List<Plan> personalUnstartPlans;
    
    private List<Plan> personalTravelingPlans;
    
    private List<Plan> personalOverPlans;
    
    private List<Plan> personalRatedPlans;
    
    private List<Plan> teamUnstartPlans;
    
    private List<Plan> teamTravelingPlans;
    
    private List<Plan> teamOverPlans;
    
    private List<Plan> teamRatedPlans;
    
    public String getUnstart() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        makeList();
        return UNSTART;
    }
    
    public String getTraveling() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        makeList();
        return TRAVELING;
    }
    
    public String getOver() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        makeList();
        return OVER;
    }
    
    public String getRated() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        makeList();
        return RATED;
    }
    
    @Override
    public String execute() throws Exception {
        String userId = tools.UserState.getUsername();
        if (userId == null)
            return LOGIN;
        plans = Plan.getPlan(userId);
        makeList();
        return SUCCESS;
    }
    
    private void makeList() {
        personalUnstartPlans = new LinkedList<Plan>();
        personalTravelingPlans = new LinkedList<Plan>();
        personalOverPlans = new LinkedList<Plan>();
        personalRatedPlans = new LinkedList<Plan>();
        teamUnstartPlans = new LinkedList<Plan>();
        teamTravelingPlans = new LinkedList<Plan>();
        teamOverPlans = new LinkedList<Plan>();
        teamRatedPlans = new LinkedList<Plan>();
        for (Plan plan : plans) {
            if (plan.isTeamPlan())
                if (plan.isUnstart())
                    teamUnstartPlans.add(plan);
                else if (plan.isTraveling())
                    teamTravelingPlans.add(plan);
                else if (plan.isRated())
                    teamRatedPlans.add(plan);
                else
                    teamOverPlans.add(plan);
            else
                if (plan.isUnstart())
                    personalUnstartPlans.add(plan);
                else if (plan.isTraveling())
                    personalTravelingPlans.add(plan);
                else if (plan.isRated())
                    personalRatedPlans.add(plan);
                else
                    personalOverPlans.add(plan);
        }
    }
    
    public List<Plan> getPlans() {
        return plans;
    }

    public List<Plan> getPersonalUnstartPlans() {
        return personalUnstartPlans;
    }

    public List<Plan> getPersonalTravelingPlans() {
        return personalTravelingPlans;
    }

    public List<Plan> getPersonalOverPlans() {
        return personalOverPlans;
    }

    public List<Plan> getTeamUnstartPlans() {
        return teamUnstartPlans;
    }

    public List<Plan> getTeamTravelingPlans() {
        return teamTravelingPlans;
    }

    public List<Plan> getTeamOverPlans() {
        return teamOverPlans;
    }

    public List<Plan> getPersonalRatedPlans() {
        return personalRatedPlans;
    }

    public List<Plan> getTeamRatedPlans() {
        return teamRatedPlans;
    }
    
}
