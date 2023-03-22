package edu.odu.cs.cs350.pne;


public class Course {
    private String crn;
    private String subj;
    private String crse;
    private int xlstCap;
    private int enr;
    private String link;
    private String xlstGroup;
    private int overallCap;
    private int overallEnr;

    private String courseName;

    // doesn't have a XLST GROUP
    public Course(String crn, String subj, String crse, int xlstCap, int enr, String link, int overallCap, int overallEnr) {
        this.crn = crn;
        this.subj = subj;
        this.crse = crse;
        this.xlstCap = xlstCap;
        this.enr = enr;
        this.link = link;
        this.xlstGroup = "";
        this.overallCap = overallCap;
        this.overallEnr = overallEnr;

        this.courseName = subj + crse;
    }

    // has a XLST GROUP
    public Course(String crn, String subj, String crse, int xlstCap, int enr, String link, String xlstGroup, int overallCap, int overallEnr) {
        this.crn = crn;
        this.subj = subj;
        this.crse = crse;
        this.xlstCap = xlstCap;
        this.enr = enr;
        this.link = link;
        this.xlstGroup = xlstGroup;
        this.overallCap = overallCap;
        this.overallEnr = overallEnr;

        this.courseName = subj + crse;
    }

    public String getCRN() {
        return crn;
    }

    public String getSubj() {
        return subj;
    }

    public String getCrse() {
        return crse;
    }

    public int getXlstCap() {
        return xlstCap;
    }

    public int getEnrollment() {
        return enr;
    }

    public String getLink() {
        return link;
    }

    public String getXlstGroup() {
        return xlstGroup;
    }

    public int getOverallCap() {
        return overallCap;
    }

    public int getOverallEnr() {
        return overallEnr;
    }
    
    public String getCourseName() {
        return courseName;
    }
}
