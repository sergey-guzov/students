package com.maintask.exceptions.university;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    Faculties faculty;
    List<Group> groups;

    public Faculty(Faculties faculty, List<Group> groups) {
        this.faculty = faculty;
        this.groups = groups;
    }
    public Faculty(Faculties faculty) {
        this.faculty = faculty;
        this.groups = new ArrayList<>();
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public List<Group> getGroups() {
        if (groups.isEmpty()) throw new RuntimeException("No groups attached to the faculty. Add at least one!");
        return groups;
    }
    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public boolean addGroup(Group group) {
        List<Group> duplicatedGroup = groups.stream().filter(g -> g.equals(group)).toList();
        if (!duplicatedGroup.isEmpty()) throw new RuntimeException("This group is already added to the faculty");
        return groups.add(group);
    }

    public double averageFacultyGradeForSubject (String subject) {

        List<Double> groupsAverageGrade = getGroups().stream().map(group -> group.averageGroupGradeForSubject(subject)).toList();
        if (groupsAverageGrade.isEmpty()) throw new RuntimeException("Groups don't have selected subject " + subject);
        double totalSum = 0.0;
        for (Double grade:groupsAverageGrade) {
            totalSum += grade;
        }
        if (totalSum/groupsAverageGrade.size() == 0.0) System.out.println("Students have no grades for selected subject yet");
        return totalSum/groupsAverageGrade.size();
    }

}
