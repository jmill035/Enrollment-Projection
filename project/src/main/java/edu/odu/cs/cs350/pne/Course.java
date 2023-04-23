package edu.odu.cs.cs350.pne;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String subj;
    private String crse;

    private String courseName;

    private List<Section> sections;

    public Course(String subj, String crse) {
        this.subj = subj;
        this.crse = crse;
  
        this.courseName = subj + crse;

        this.sections = new ArrayList<>();
    }

    public String getSubj() {
        return subj;
    }

    public String getCrse() {
        return crse;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public Section searchSection(String crn) {
        for(Section s : sections) {
            if(s.getCRN().equals(crn)){
                return s;
            }
        }

        return null;
    }

    public int calcOverallEnrollment() {
        int overallEnr = 0;
        for(Section section : sections) {
            Offering offering = section.getOffering();
            if(offering != null) {
                overallEnr += offering.getOverallEnr();
            }
        }
        
        return overallEnr;
    }

    public int calcOverallCap() {
        int overallCap = 0;
        for(Section section : sections) {
            Offering offering = section.getOffering();
            if(offering != null) {
                overallCap += offering.getOverallCap();
            }
        }

        return overallCap;
    }

   @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append("\n");
        for(Section s : sections) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}

