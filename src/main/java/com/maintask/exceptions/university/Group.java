package com.maintask.exceptions.university;

import com.maintask.exceptions.students.Student;
import com.maintask.exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {

    private String name;
    private List<Student> students;
    private Faculty faculty;

    public Group(String name, Faculty faculty) {
        students = new ArrayList<>();
        this.faculty = faculty;
        this.name = name;
    }

    public List<Student> getStudents() {
        if (students.isEmpty()) throw new RuntimeException("No students attached to the group. Add at least one!");
        return students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    public boolean addStudents(Student student) {
        List<Student> duplicatedStudent = students.stream().filter(s -> s.equals(student)).toList();
        if (!students.isEmpty()) throw new RuntimeException("This student is already added to the group");
        return students.add(student);
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double averageGroupGradeForSubject (String subject) {

        List<Double> studentsAverageGrade = getStudents().stream().map(student -> student.averageStudentGradeForSubject(subject)).toList();
        if (studentsAverageGrade.isEmpty()) throw new RuntimeException("Students doesn't have selected subject " + subject);
        double totalSum = 0.0;
        for (Double grade:studentsAverageGrade) {
            totalSum += grade;
        }
        if (totalSum/studentsAverageGrade.size() == 0.0) System.out.println("Students have no grades for selected subject yet");
        return totalSum/studentsAverageGrade.size();
    }
}
