package com.wallofshame.domain.dashBoard;

import java.util.HashMap;


public class Project {
    private String name;

    private HashMap<Integer,People> peopleMap = new HashMap<Integer,People>();

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, People> getPeopleMap() {
        return peopleMap;
    }

    public boolean hasPeople(int ID) {
        return peopleMap.containsKey(ID) ;//To change body of created methods use File | Settings | File Templates.
    }

    public People getPeopleById(int ID) {
        return peopleMap.get(ID);  //To change body of created methods use File | Settings | File Templates.
    }

    public int getPeopleSize() {
        return peopleMap.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public void addPeopleRecordByStrings(String[] strings) {
        People people;
        if (hasPeople(Integer.parseInt(strings[10]))){
            people = getPeopleById(Integer.parseInt(strings[10]));
        }else {
            people = new People(Integer.parseInt(strings[10]),strings[1]);
        }
        people.addWorkDay(strings[5]);
        peopleMap.put(people.getID(),people);
    }
}
