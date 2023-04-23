package edu.odu.cs.cs350.pne;


public class Offering {
    private String xlstGroup;
    private int overallCap;
    private int overallEnr;

    public Offering(String xlstGroup, int overallCap, int overallEnr) {
        this.xlstGroup = xlstGroup;
        this.overallCap = overallCap;
        this.overallEnr = overallEnr;
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

    // need toString?
}
