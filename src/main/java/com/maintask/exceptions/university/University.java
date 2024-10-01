package com.maintask.exceptions.university;

import com.maintask.exceptions.exception.UniversityGradeException;

import java.util.ArrayList;
import java.util.List;

public class University {

    final String name = "BSUT";
    List <Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University() {
        this.faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public boolean addFaculty(Faculty faculty) {
        List<Faculty> duplicatedFaculty = faculties.stream().filter(f -> f.equals(faculty)).toList();
        if (!duplicatedFaculty.isEmpty()) throw new UniversityGradeException("This faculty is already added to the university");
        return faculties.add(faculty);
    }

    public double averageUniversityGradeForSubject (String subject) {

        List<Double> universityAverageGrade = getFaculties().stream().map(faculty -> faculty.averageFacultyGradeForSubject(subject)).toList();
        if (universityAverageGrade.isEmpty()) throw new UniversityGradeException("Students doesn't have selected subject " + subject);
        double totalSum = 0.0;
        for (Double grade:universityAverageGrade) {
            totalSum += grade;
        }
        //if (totalSum/universityAverageGrade.size() == 0.0) throw new UniversityGradeException("Students have no grades for selected subject yet");
        return totalSum/universityAverageGrade.size();
    }
}
