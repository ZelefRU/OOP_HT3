package org.example.Study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Stream extends StudyGroup implements Iterable<Student>{
    protected List<StudyGroup> studyGroupList = new ArrayList<>();
    protected int groupsCount;
    protected int id;

    public Stream(){}

    public Stream(List<StudyGroup> studyGroupList) {
        this.studyGroupList = studyGroupList;
        this.groupsCount = studyGroupList.size();
        id = generateUniqueId(); // Генерируем уникальный ID при создании объекта
    }

    // Метод генерации уникального ID, по аналогии с предыдущим ответом
    private static int lastId = -1;

    private int generateUniqueId() {
        return ++lastId;
    }


    public void addGroup(StudyGroup studyGroup) {
        studyGroupList.add(studyGroup);
        groupsCount++;
    }

    public void addGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.add(new StudyGroup(groupNumber, studentList));
        groupsCount++;
    }

    public void removeGroup(StudyGroup studyGroup) {
        studyGroupList.remove(studyGroup);
        groupsCount--;
    }

    public void removeGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.remove(new StudyGroup(groupNumber, studentList));
        groupsCount--;
    }

    public List<StudyGroup> getStudyGroupList() {
        return studyGroupList;
    }

    public int getGroupsCount() {
        return groupsCount;
    }

    public int getId() {
        return id;
    }

    public String getShortInfo() {
        StringBuilder result = new StringBuilder();
        result.append("=".repeat(10)).append(" Stream Info ").append("=".repeat(10)).append('\n');
        int totalStudentsCount = 0;
        for (StudyGroup group : studyGroupList) {
            totalStudentsCount += group.getStudentsCount();
        }

        result.append(" - Groups count: ").append(groupsCount).append("\n");
        result.append(" - Total students count: ").append(totalStudentsCount).append('\n');
        return result.toString();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("=".repeat(10)).append(" Stream Info ").append("=".repeat(10)).append('\n');
        int totalStudentsCount = 0;
        for (StudyGroup group : studyGroupList) {
            totalStudentsCount += group.getStudentsCount();
        }

        result.append(" - Groups count: ").append(groupsCount).append("\n");
        result.append(" - Groups numbers: ");
        StringJoiner groupNumberList = new StringJoiner(", ");
        for (StudyGroup group : studyGroupList) {
            groupNumberList.add(String.valueOf(group.getGroupNumber()));
        }
        result.append(groupNumberList).append("\n");
        result.append(" - Total students count: ").append(totalStudentsCount).append('\n');
        result.append("-".repeat(33));

        for (StudyGroup group : studyGroupList) {
            result.append("\n").append("   ┌╴Info for group #").append(group.getGroupNumber());
            result.append("\n   └╴Student in group:");
            for (Student student : group) {
                result.append("\n      ├╴").append(student.getFullName());
            }
            result.append("\n      ┴╴╴╴╴╴╴╴╴╴╴╴╴╴╴╴╴╴╴");
            result.append("\n      Student Count: ").append(group.studentsCount).append("\n");
        }

        result.append('\n').append("=".repeat(10)).append(" Stream Info ").append("=".repeat(10));
        return result.toString();
    }

}
