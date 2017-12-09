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

    private String start;
    
    private String end;
    
    private String name;
    
    private Date date;
    
    private Path path;
    
    private List<Path> recommendPaths;

    @Override
    public void validate() {
        super.validate();
        if (date.compareTo(Date.valueOf(LocalDate.now())) <= 0)
            addFieldError("date", "请选择正确的开始日期");
    }
    
    @Override
    public String execute() throws Exception {
        recommendPaths = Path.getPath(start, end);
        ListIterator<Path> iter = recommendPaths.listIterator(recommendPaths.size());
        while (iter.hasPrevious()) {
            Path path = iter.previous();
            if (path.size() == 2) {
                setPath(path);
                Plan.newPersonalPlan(tools.UserState.getUsername()
                        , date, path, name);
                return SUCCESS;
            }
        }
        return ERROR;
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

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    
}