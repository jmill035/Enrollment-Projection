package edu.odu.cs.cs350.pne;

import java.util.List;

public class Offering {
    private String xlstGroup;
    private int overallCap;
    private int overallEnr;

    public Offering(String xlstGroup, int overallCap, int overallEnr) {
        this.xlstGroup = xlstGroup;
        this.overallCap = overallCap;
        this.overallEnr = overallEnr;
    }

    public void setXlstGroup(String xlstGroup) {
        this.xlstGroup = xlstGroup;
    }

    public void setOverallCap(int overallCap) {
        this.overallCap = overallCap;
    }

    public void setOverallEnr(int overallEnr) {
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

    private List<Offering> offerings;
    public Offering(List<Offering> offerings){
        this.offerings = offerings;
    }
}
