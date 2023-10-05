package org.example.Study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup extends Student implements Iterable<Student> {
    protected List<Student> studentList = new ArrayList<>();
    protected int groupNumber;
    protected int studentsCount;

    public StudyGroup(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public StudyGroup(){}

    public StudyGroup(int groupNumber, List<Student> studentList) {
        this.groupNumber = groupNumber;
        this.studentList = studentList;
        studentsCount = studentList.size();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        studentsCount++;
    }

    public void addListStudents(List<Student> studentList) {
        this.studentList = studentList;
        studentsCount = studentList.size();
    }

    public void addStudent(String firstName, String lastName) {
        studentList.add(new Student(firstName, lastName));
        studentsCount++;
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
        studentsCount--;
    }

    public void removeStudent(String fistName, String lastName) {
        studentList.remove(new Student(firstName, lastName));
        studentsCount--;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-".repeat(5)).append(" Student in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        int number = 1;
        for (Student student:studentList) {
            result.append("  ").append(number).append(". ").append(student.getFullName()).append("\n");
            number++;
        }
        result.append("-".repeat(5)).append(" Student in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        return result.toString();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    @Override
    public Iterator<Student> iterator() {
        return studentList.iterator();
    }
}
