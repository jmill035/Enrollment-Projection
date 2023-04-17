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

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setCrse(String crse) {
        this.crse = crse;
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
        sections.add(section);
    }

    public Section getSection(String crn) {
        for(Section s : sections) {
            if(s.getCRN().equals(crn)){
                return s;
            }
        }

        return null;
    }

   //toString?
}

