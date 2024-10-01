package com.maintask.exceptions.creator;

import com.maintask.exceptions.students.Student;
import com.maintask.exceptions.subjects.Subject;
import com.maintask.exceptions.subjects.Subjects;
import com.maintask.exceptions.university.Faculties;
import com.maintask.exceptions.university.Faculty;
import com.maintask.exceptions.university.Group;
import com.maintask.exceptions.university.University;

public class App {
    public static void main(String[] args) {
        University university = new University();
        Faculty facultyUPP = new Faculty(Faculties.UPP);
        university.addFaculty(facultyUPP);
        Group groupUA51 = new Group("UA51",facultyUPP);
        facultyUPP.addGroup(groupUA51);
        Student student1 = new Student("John", "Doe", facultyUPP, groupUA51);
        Student student2 = new Student("Mick", "Donn", facultyUPP, groupUA51);
        groupUA51.addStudents(student1);
        groupUA51.addStudents(student2);
        Subject subjectMath1 = new Subject(Subjects.MATH);
        student1.addSubject(subjectMath1);
        subjectMath1.addGrade(6);
        subjectMath1.addGrade(9);
        subjectMath1.addGrade(10);
        subjectMath1.addGrade(8);
        Subject subjectMath2 = new Subject(Subjects.MATH);
        student2.addSubject(subjectMath2);
     /*   subjectMath2.addGrade(4);
        subjectMath2.addGrade(6);
        subjectMath2.addGrade(7);
        subjectMath2.addGrade(7);*/
        System.out.println("Average grade of student1 = " + student1.averageStudentGradeForSubject("math"));
        System.out.println("Average grade of student1 for all subjects = " + student1.averageStudentGradeForAllSubjects());
        System.out.println("Average grade of student2 = " + student2.averageStudentGradeForSubject("math"));
        System.out.println("Average grade of group = " + groupUA51.averageGroupGradeForSubject("math"));
        System.out.println("Average grade of faculty = " + facultyUPP.averageFacultyGradeForSubject("math"));
        System.out.println("Average grade of university = " + university.averageUniversityGradeForSubject("math"));


    }
}
