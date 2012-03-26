package com.wallofshame.domain.dashBoard;

import org.joda.time.DateTime;

public class People {

    private String name;

    private int ID;

    private int[] daysInWeeks = new int[5];

    public People(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public int getDaysInFirstWeek() {
        return daysInWeeks[0];  //To change body of created methods use File | Settings | File Templates.
    }


    public int getDaysInSecondWeek() {
        return daysInWeeks[1];  //To change body of created methods use File | Settings | File Templates.
    }

    public int getDaysInThirdWeek() {
        return daysInWeeks[2];  //To change body of created methods use File | Settings | File Templates.
    }

    public int getDaysInForthWeek() {
        return daysInWeeks[3];  //To change body of created methods use File | Settings | File Templates.
    }

    public int getDaysInFifthWeek() {
        return daysInWeeks[4];  //To change body of created methods use File | Settings | File Templates.
    }

    public void addWorkDay(String dateString) {
        String[] dateStrings = dateString.split("/");
        DateTime dateTime = new DateTime(Integer.parseInt("20" + dateStrings[2]), Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[1]), 0, 0, 0, 0);
        int weekInMonth = (dateTime.getDayOfMonth() + 7 - dateTime.getDayOfWeek()) / 7 + 1;
        daysInWeeks[weekInMonth-1]+=1;
    }
}
