package com.maintask.exceptions.students;

import com.maintask.exceptions.subjects.Subject;
import com.maintask.exceptions.subjects.Subjects;
import com.maintask.exceptions.university.Faculty;
import com.maintask.exceptions.university.Group;

import java.util.ArrayList;
import java.util.List;
public class Student {

    private String firstName;
    private String secondName;
    private Faculty faculty;
    private Group group;
    private List<Subject> subjects;

    public Student() {
    }

    public Student(String firstName, String secondName, Faculty faculty, Group group) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.faculty = faculty;
        this.group = group;
        subjects = new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean addSubject(Subject subject) {
        for (Subject s:subjects) {
            if (s.equals(subject))
                throw new RuntimeException("Subject already added to the student");
        }
        return subjects.add(subject);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Group getGroup() {
        return group;
    }

    public List<Subject> getSubjects() {
        if (subjects.isEmpty()) throw new RuntimeException("Student has no subjects. Add new subject for the student!");
        return subjects;
    }

    public double averageStudentGradeForSubject (String subject) {
        try {
            Subjects.valueOf(subject.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new RuntimeException("This subject is not exists");
        }
        List<Subject> selectedSubject = getSubjects().stream().filter(s -> s.getSubject().name().equalsIgnoreCase(subject)).toList();
        if (selectedSubject.isEmpty()) throw new RuntimeException("Student doesn't have selected subject");
        return selectedSubject.get(0).averageGrade();
    }

    public double averageStudentGradeForAllSubjects() {
        double totalSum = 0;
        List<Double> studentAverageGrades = getSubjects().stream().map(Subject::averageGrade).toList();
        if (studentAverageGrades.isEmpty()) throw new RuntimeException("Student doesn't have any grades yet");
        for (Double grade:studentAverageGrades) {
            totalSum += grade;
        }
        if (totalSum/studentAverageGrades.size() == 0.0) System.out.println("Students have no grades for subjects yet");
        return totalSum/studentAverageGrades.size();

    }

}
