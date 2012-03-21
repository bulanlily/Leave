package com.wallofshame.domain.leave;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Employee {


    private int id;
    private String name;
    private String office;
    private DateTime dateOfJob;
    private ArrayList<Leave> historyLeaves;


    public Employee(DateTime dateOfJob, int id, String name, String office) {
        this.dateOfJob = dateOfJob;
        this.id = id;
        this.name = name.replace(",","");
        this.office = office;
        this.historyLeaves = new ArrayList<Leave>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id == employee.id) return true;
        else return false;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public void setDateOfJob(DateTime date) {
        this.dateOfJob = date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getOffice() {
        return office;
    }

    public DateTime getDateOfJob() {
        return dateOfJob;
    }


    public int getTenner() {
        return Constants.getCurrentYear() - dateOfJob.getYear();
    }
    
    public String getPresentTenner(){
        return (getTenner()>=1)?String.valueOf(getTenner()):(new DateTime().getMonthOfYear() - dateOfJob.getMonthOfYear())+"mon";
    }

    public double getRemainingAnnualLeave() {
        double usedLeave = 0;
        for (Leave leave : historyLeaves) {
            boolean isAnnualLeave = leave.isAnnualLeave();
            if (isAnnualLeave) {
                usedLeave += leave.getHours()/Constants.WORK_TIME_A_DAY;
            }
        }
        return  getAnnualLeaveAtPresent()-Math.round(usedLeave*10.0)/10.0;
    }

    public double getAnnualLeaveAtPresent(){
        double availableLeave = (double) getRightActualRateByYear() / Constants.getDaysOfTheYear() * Constants.getCurrentDayOfYear();
        return  Math.round(availableLeave*10.0)/10.0;
    }


    public int getRightActualRateByYear() {
        if (Constants.FIRST_STEP >= this.getTenner()) {
            return Constants.FIRST_ACTUAL_DAYS_BY_YEAR;
        } else if (Constants.SECOND_STEP >= this.getTenner()) {
            return Constants.SECOND_ACTUAL_DAYS_BY_YEAR;
        } else if (Constants.THIRD_STEP > +this.getTenner()) {
            return Constants.THIRD_ACTUAL_DAYS_BY_YEAR;
        } else {
            return Constants.FORTH_ACTUAL_DAYS_BY_YEAR;
        }

    }

    public double getRightActualRateByMonth() {
        return getRightActualRateByYear() / (double) Constants.MONTH_A_YEAR;
    }

    public int addHistoryLeavesSize(Leave leave) {
        historyLeaves.add(leave);
        return historyLeaves.size();
    }

    public List<Leave> getHistoryLeaves() {
        return historyLeaves;
    }
}
