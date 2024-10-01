package com.maintask.exceptions.subjects;

import com.maintask.exceptions.exception.AddNewGradeException;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private Subjects subject;
    private List<Integer> grades;

    public Subject(Subjects subject) {
        this.subject = subject;
        grades = new ArrayList<>();
    }

    public Subject(Subjects subject, List<Integer> grades) {
        this.subject = subject;
        this.grades = grades;
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
        if(grade < 0 || grade > 10) throw new AddNewGradeException("Grade cannot be less than 0 and more than 10");
        return grades.add(grade);
    }

    public double averageGrade() {
        if (grades.isEmpty()) return -1.0; // This value is used to avoid influence of Students who have no
                                           // grades yet on the Average Grade for the group,faculty or  university
        int totalSumOfAllGrades = 0;
        for (Integer grade:grades) {
            totalSumOfAllGrades += grade;
        }
        try {
            return (double) totalSumOfAllGrades/grades.size();
        } catch (ArithmeticException e) {
            return 0.0;
        }
    }
}
