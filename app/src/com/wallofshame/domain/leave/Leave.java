package com.wallofshame.domain.leave;


import org.joda.time.DateTime;

public class Leave {

    private DateTime leaveDate;
    private String subProj;
    private String task;
    private double hours;

    public Leave(DateTime leaveDate, String subProj, String task, double hours) {
        this.leaveDate = leaveDate;
        this.subProj = subProj;
        this.task = task;
        this.hours = hours;
    }

    public boolean isAnnualLeave(){
        return true?this.subProj.contains("ANNUAL_LV"):false;
    }

    public double getHours() {
        return hours;
    }

    public DateTime getLeaveDate() {
        return leaveDate;
    }

    public String getSubProj() {
        return subProj;
    }

    public String getTask() {
        return task;
    }

}
