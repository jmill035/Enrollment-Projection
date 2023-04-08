package edu.odu.cs.cs350.pne;

public class Section {
    private String crn;
    private int xlstCap;
    private int enr;
    private String link;

    private Offering offering;
    
    public Section(String crn, int xlstCap, int enr) {
        this.crn = crn;
        this.xlstCap = xlstCap;
        this.enr = enr;
        this.link = "";
        
        this.offering = null;
    }
    
    public Section(String crn, int xlstCap, int enr, String link) {
        this.crn = crn;
        this.xlstCap = xlstCap;
        this.enr = enr;
        this.link = link;

        this.offering = null;
    }

    public void addOffering(Offering offering){
        this.offering = offering;
    }

    //add set functions?
    public void setCRN(String crn) {
        this.crn = crn;
    }

    public String getCRN() {
        return crn;
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

    public Offering getOffering() {
        return offering;
    }
}
