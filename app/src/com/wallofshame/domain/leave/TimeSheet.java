package com.wallofshame.domain.leave;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeSheet {


    HashMap<Integer, Employee> employeeHashMap;

    public TimeSheet() {
        employeeHashMap = new HashMap<Integer, Employee>();
    }

    public HashMap<Integer, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public Employee buildEmployeeFromStrings(String[] employeeString) {
        DateTime dateTime;
        dateTime = getDateByString(employeeString[7]);
        Employee employee = new Employee(dateTime, Integer.parseInt(employeeString[2]), employeeString[6], employeeString[1]);
        return employee;

    }

    public Employee findEmployeeById(int id) {
        return employeeHashMap.get(id);
    }

    public boolean addEmployeeToList(Employee employee) {
        if (employeeHashMap.containsKey(employee.getId())) {
            return false;
        } else {
            employeeHashMap.put(employee.getId(), employee);
            return true;
        }
    }

    public int addAllEmployeeToListByStrings(ArrayList<String[]> list) {
        for (String[] strings : list) {
            addEmployeeToList(buildEmployeeFromStrings(strings));
        }
        return employeeHashMap.size();
    }

    public void clear(){
        this.employeeHashMap.clear();
    }


    private DateTime getDateByString(String dateString) {
        String[] dateStrings = dateString.split("-");
        return new DateTime(Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[1]), Integer.parseInt(dateStrings[2]), 0, 0,0,0);
    }

    public void addLeaveToEmployee(Leave leave, int i) {
        Employee employee = employeeHashMap.get(i);
        if (employee != null) {
            employee.addHistoryLeavesSize(leave);
        }
    }

    public void addAllLeaveToListByStrings(ArrayList<String[]> list) {
        for (String[] strings : list) {
            addLeaveToEmployee(buildLeaveFromStrings(strings), Integer.parseInt(strings[11]));
        }
    }

    public Leave buildLeaveFromStrings(String[] leaveString) {
        DateTime dateTime = getLeaveDateByString(leaveString[6]);
        double hours = Double.parseDouble(leaveString[9]);
        return new Leave(dateTime, leaveString[5], leaveString[10], hours);

    }


    private DateTime getLeaveDateByString(String dateString) {
        String[] dateStrings = dateString.split("/");
        return new DateTime(Integer.parseInt("20" + dateStrings[2]), Integer.parseInt(dateStrings[0]), Integer.parseInt(dateStrings[1]), 0, 0,0,0);
    }


}
