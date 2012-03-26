package com.wallofshame.domain.dashBoard;


import org.joda.time.DateTime;

import java.util.Calendar;

public class REAContants {
    public static  DateTime getCurrentTime(){
        DateTime currentDate = new DateTime(2011,6,20,0,0,0,0);
        return currentDate;
    }

    public static int getWeeksInTheMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2011);
        calendar.set(Calendar.MONTH,6);
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

}
