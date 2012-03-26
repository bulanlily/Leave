package com.wallofshame.domain.leave;

import au.com.bytecode.opencsv.CSVReader;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVProcessor {
    private static final String BASIC_FOLDER_NAME = "app/excels";
    private File fileFolder;

    public String listAllFilesInBasicFolder(){
        File basicFolder = new File(BASIC_FOLDER_NAME);
        File[] files = basicFolder.listFiles();
        String listString = "";
        for(File folder:files){
            listString+=folder.getName();
            listString+="\n";
        }
        return listString;
    }
    public String getFileForderName(){
        return fileFolder.getName();
    }

    //get the lastest file folder
    public void pickUpLatestFolder() {
        File basicFolder = new File(BASIC_FOLDER_NAME);
        File[] files = basicFolder.listFiles();
        File latestFileFolder = null;
        for (File folder : files) {
            if (!verifyFileName(folder.getName())) {
                continue;
            }
            latestFileFolder = (latestFileFolder == null) ? folder : latestFileFolder;
            if (getDateByYearAndMonthString(folder.getName()).isAfter(getDateByYearAndMonthString(latestFileFolder.getName()))) {
                latestFileFolder = folder;
            }
        }
        fileFolder = latestFileFolder;

    }

    //get the folder user asked
    public void pickUpFileFolderByName(String folderName) {
        File basicFolder = new File(BASIC_FOLDER_NAME);
        fileFolder = new File(BASIC_FOLDER_NAME + "/" + folderName);
    }



    public ArrayList<String[]> getEmployeeInfo() throws IOException {
        File[] files = fileFolder.listFiles();
        ArrayList<String[]> returnList = new ArrayList<String[]>();
        CSVReader reader;
        for (File file : files) {
            reader = new CSVReader(new FileReader(file));
            String[] firstLineInfo = reader.readNext();
            if (null != firstLineInfo) {
                if (Constants.ITEMS_IN_EMPLOYEE_FILE == firstLineInfo.length) {
                    returnList = (ArrayList<String[]>) reader.readAll();
                    returnList.remove(0);
                }
            }
        }
        return returnList;
    }

    public ArrayList<String[]> getTakeOffInfo() throws IOException {
        File[] files = fileFolder.listFiles();
        ArrayList<String[]> returnList = new ArrayList<String[]>();
        CSVReader reader;
        for (File file : files) {
            reader = new CSVReader(new FileReader(file));
            String[] firstLineInfo = reader.readNext();
            if (null != firstLineInfo) {
                if (Constants.ITEMS_IN_TIME_OFF_FILE == firstLineInfo.length) {
                    returnList = (ArrayList<String[]>) reader.readAll();
                    returnList.remove(0);
                    returnList.remove(1);
                }
            }
        }
        return returnList;
    }

    //verifyThe Folder's Name
    private boolean verifyFileName(String fileName) {
        String[] timeStrings = fileName.split("-");
        if (2 < timeStrings.length) {
            return false;
        }
        for (String time : timeStrings) {
            for (int i = 0; i < time.length(); i++) {
                if (!Character.isDigit(time.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }



    //get the date by folder name
    private DateTime getDateByYearAndMonthString(String timeString) {
        String[] timeStrings = timeString.split("-");
        return new DateTime(Integer.parseInt(timeStrings[0]), Integer.parseInt(timeStrings[1]), 1, 0, 0,0,0);
    }
}
