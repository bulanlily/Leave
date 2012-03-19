package com.wallofshame.domain;

import com.wallofshame.controller.ShameController;

import java.util.ArrayList;
import java.util.List;

/**
 * Since: 3/15/12
 */
public class PeopleMissingTimeSheet {

    private ArrayList<String> names;

    public PeopleMissingTimeSheet() {
        names = new ArrayList<String>();
    }

    public void addName(String name) {
        names.add(name);
    }

    public List<String> names() {
         addName(""+System.currentTimeMillis());
        return names;
    }
}
