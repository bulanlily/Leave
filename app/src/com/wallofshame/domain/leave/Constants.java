package com.wallofshame.domain.leave;

import org.joda.time.DateTime;

public class Constants {

	public static final int FIRST_STEP = 1;


	public static final int SECOND_STEP =3;


	public static final int THIRD_STEP = 6;


    public static final int FIRST_ACTUAL_DAYS_BY_YEAR = 10;

    public static final int SECOND_ACTUAL_DAYS_BY_YEAR = 15;

    public static final int THIRD_ACTUAL_DAYS_BY_YEAR = 20;

    public static final int FORTH_ACTUAL_DAYS_BY_YEAR = 25;


    public static final int MONTH_A_YEAR = 12;
    public static  final int WORK_TIME_A_DAY = 8;

    public static final int ITEMS_IN_EMPLOYEE_FILE = 8;

    public static final int ITEMS_IN_TIME_OFF_FILE = 15;

    public static final String ANNUAL_LV = "ANNUAL_LV";

    public static int getCurrentYear(){
        DateTime currentDate = new DateTime();
        return  currentDate.getYear();
    }

    public static  int getCurrentDayOfYear(){
        DateTime currentDate = new DateTime();
        return currentDate.getDayOfYear();
    }

    public static  int  getDaysOfTheYear(){
        DateTime currentDate = new DateTime();
        currentDate.getYear();
        currentDate.getMonthOfYear();
        currentDate.getDayOfMonth();
        return  currentDate.year().isLeap()?366:365;
    }

}
