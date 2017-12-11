package action.personal;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

import com.opensymphony.xwork2.ActionSupport;

import model.Location;
import model.Path;
import model.Plan;

public class NewPersonalTravelPlanAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static final String NEXT = "next";
    
    private String start;
    
    private String end;
    
    private String name;
    
    private Date date;
    
    private long planId = 0;
    
    private Plan plan;
    
    private long choosenPathId;
    
    private List<Path> recommendPaths;
    
    @Override
    public void validate() {
        if (planId == 0) {
            if (getStart() == null || getStart().trim().equals(""))
                addFieldError("start", "请填写出发地!");
            if (getEnd() == null || getEnd().trim().equals(""))
                addFieldError("end", "请填写目的地!");
            if (getName() == null || getName().trim().equals("")
                    || getName().length() > 50)
                addFieldError("name", "计划名不能为空, 且不多于50个字符");
            if (getDate().getTime() < (new java.util.Date()).getTime())
                addFieldError("date", "请填写正确的日期");
        }
    }
    
    public String newTravelPlan() throws Exception {
        if (tools.UserState.isMember() == false)
            return LOGIN;
        recommendPaths = Path.getPath(start, end);
        ListIterator<Path> iter = recommendPaths.listIterator(recommendPaths.size());
        while (iter.hasPrevious()) {
            Path path = iter.previous();
            if (path.size() == 2) {
                plan = Plan.newPersonalPlan(tools.UserState.getUsername()
                        , date, path, name);
                planId = plan.getId();
                break;
            }
        }
        return NEXT;
    }
    
    public String choosePath() throws Exception {
        setPlan(Plan.getPlan(planId));
        getPlan().changePath(Path.getPath(getChoosenPathId()));
        getPlan().save();
        return SUCCESS;
    }
    
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        if (start != null)
            Location.addLocation(start);
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        if (end != null)
            Location.addLocation(end);
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Path> getRecommendPaths() {
        return recommendPaths;
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

    public long getChoosenPathId() {
        return choosenPathId;
    }

    public void setChoosenPathId(long choosenPathId) {
        this.choosenPathId = choosenPathId;
    }
    
}
