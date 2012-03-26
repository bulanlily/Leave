package com.wallofshame.domain.dashBoard;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private HashMap<String, Project> projectHashMap = new HashMap<String, Project>();

    public Project addInfomationFromStrings(String[] strings) {
        Project project = null;
        if (projectHashMap.containsKey(strings[3])) {
            project = getProjectByName(strings[3]);
        } else {
            project = new Project(strings[3]);
        }
        project.addPeopleRecordByStrings(strings);
        projectHashMap.put(project.getName(), project);
        return project;
    }

    public int addAllInfomationToMapByStrings(ArrayList<String[]> list) {
        for (String[] strings : list) {
            addInfomationFromStrings(strings);
        }
        return projectHashMap.size();
    }

    public HashMap<String, Project> getProjectHashMap() {
        return projectHashMap;
    }

    public int getProjectsSize() {
        return projectHashMap.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public Project getProjectByName(String name) {
        return projectHashMap.get(name);
    }

    public void  clear(){
        projectHashMap.clear();
    }


}
