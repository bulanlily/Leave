package com.wallofshame.domain.dashBoard;

import au.com.bytecode.opencsv.CSVReader;
import com.wallofshame.domain.leave.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DashBoardProcessor {
    private static final String BASIC_FOLDER_NAME = "app/REA";
    private File fileFolder;

    public DashBoardProcessor() {
        fileFolder = new File(BASIC_FOLDER_NAME);
    }

    public ArrayList<String[]> getDashBoardList() throws IOException {
        File[] files = fileFolder.listFiles();
        ArrayList<String[]> returnList = new ArrayList<String[]>();
        CSVReader reader;
        for (File file : files) {
            reader = new CSVReader(new FileReader(file));
            String[] lineInfo;
            while ((lineInfo = reader.readNext()) != null) {
                if (lineInfo[2].equals("REA0001")&&(!lineInfo[6].equals("0.00"))) {
                    returnList.add(lineInfo);
                }
            }
        }
        return returnList;
    }

}
