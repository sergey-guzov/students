package com.maintask.exceptions.subjects;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private Subjects subject;
    private List<Integer> grades;

    public Subject(Subjects subject) {
        this.subject = subject;
        grades = new ArrayList<>();
    }

    public Subjects getSubject() {
        return subject;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public boolean addGrade(int grade){
        if(grade < 0 || grade > 10) throw new RuntimeException();
        return grades.add(grade);
    }

    public double averageGrade() {
        //if (grades.isEmpty()) throw new RuntimeException("Student has no grades for selected subject " + subject.name());
        int totalSumOfAllGrades = 0;
        for (Integer grade:grades) {
            totalSumOfAllGrades += grade;
        }
        try {
            double averageGrade = (double) totalSumOfAllGrades/grades.size();
            return Math.round(averageGrade);
        } catch (ArithmeticException e) {
            return 0.0;
        }
    }
}
