package model;

public class Plan implements localization.LocalSettings {
    public static final byte DEFAULT = 0x00;
    public static final byte TRAVEL_STATE = 0x03;
    public static final byte RELATE_STATE = 0x08;
    
    public static final byte UNSTART = 0x01;
    public static final byte TRAVELING = 0x02;
    public static final byte OVER = 0x03;
    public static final byte TEAM = 0x08;
    public static final byte PERSONAL = 0x00;
    
    
    private long id;
    
    private byte state = 0;
    
    
    
    public boolean isStart() {
        return (state & TRAVEL_STATE) != UNSTART;
    }
    
    public boolean isTraveling() {
        return (state & TRAVEL_STATE) == TRAVELING;
    }
    
    public boolean isOver() {
        return (state & TRAVEL_STATE) == OVER;
    }
    
    public boolean isTeamPlan() {
        return (state & RELATE_STATE) == TEAM;
    }
    
    public boolean isPersonalPlan() {
        return (state & RELATE_STATE) == PERSONAL;
    }
}
