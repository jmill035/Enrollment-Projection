package edu.odu.cs.cs350.pne;

public class SemesterReport {

    char marker;

    public char projectedEnrollment(int projected, int cap) {

        if(projected > cap) {
            return '*';
        }
        else {
            return ' ';
        }

    }
}