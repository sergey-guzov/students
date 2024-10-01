package com.maintask.exceptions.university;

import com.maintask.exceptions.exception.GroupGradeException;
import com.maintask.exceptions.students.Student;

import java.util.ArrayList;
import java.util.List;

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
        if (students.isEmpty()) throw new GroupGradeException("No students attached to the group. Add at least one!");
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
        if (!duplicatedStudent.isEmpty()) throw new GroupGradeException("This student is already added to the group");
        return students.add(student);
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double averageGroupGradeForSubject (String subject) {
        Double valueStudentWithoutGrades = -1.0;
        List<Double> studentsAverageGrade = getStudents().stream().map(student -> student.averageStudentGradeForSubject(subject)).toList();
        if (studentsAverageGrade.isEmpty()) throw new GroupGradeException("Students doesn't have selected subject " + subject);
        List<Double> studentsAverageGradeExcludedStudentWithoutGrades = studentsAverageGrade.stream().filter(d -> !d.equals(valueStudentWithoutGrades)).toList();
        if (studentsAverageGradeExcludedStudentWithoutGrades.isEmpty()) throw new GroupGradeException("Students have no grades for selected subject yet");
        double totalSum = 0.0;
        for (Double grade:studentsAverageGradeExcludedStudentWithoutGrades) {
            totalSum += grade;
        }
        return totalSum/studentsAverageGradeExcludedStudentWithoutGrades.size();
    }
}
