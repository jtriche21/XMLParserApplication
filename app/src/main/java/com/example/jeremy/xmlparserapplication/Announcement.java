package com.example.jeremy.xmlparserapplication;

import java.util.Date;

/**
 * Created by Jeremy on 4/17/2018.
 */

public class Announcement {
    private String title;
    private String department;
    private String course;
    private String date;
    private String location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString(){
        return title + "\n"
                + department + "\n"
                + "Course: " + course + "\n"
                + date + " at " + location;
    }
}
