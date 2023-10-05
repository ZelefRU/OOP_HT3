package org.example.Study;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Stream extends StudyGroup implements Iterable<Student>{
    protected List<StudyGroup> studyGroupList = new ArrayList<>();
    private static int lastId = -1;
    protected int groupsCount;
    protected int id;

    /**
     * Конструктор для создания потока на основе списка учебных групп.
     *
     * @param studyGroupList Список учебных групп, из которых будет состоять поток.
     */
    public Stream(List<StudyGroup> studyGroupList) {
        this.studyGroupList = studyGroupList;
        this.groupsCount = studyGroupList.size();
        id = generateUniqueId(); // Генерируем уникальный ID при создании объекта
    }

    /**
     * Генерирует и возвращает уникальный идентификатор для потока.
     *
     * @return Уникальный идентификатор потока.
     */
    private int generateUniqueId() {
        return ++lastId;
    }

    /**
     * Добавляет учебную группу к потоку.
     *
     * @param studyGroup Добавляемая учебная группа.
     */
    public void addGroup(StudyGroup studyGroup) {
        studyGroupList.add(studyGroup);
        groupsCount++;
    }

    /**
     * Создает и добавляет учебную группу к потоку на основе номера группы и списка студентов.
     *
     * @param groupNumber  Номер добавляемой учебной группы.
     * @param studentList  Список студентов для добавляемой группы.
     */
    public void addGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.add(new StudyGroup(groupNumber, studentList));
        groupsCount++;
    }

    /**
     * Удаляет учебную группу из потока.
     *
     * @param studyGroup Удаляемая учебная группа.
     */
    public void removeGroup(StudyGroup studyGroup) {
        studyGroupList.remove(studyGroup);
        groupsCount--;
    }

    /**
     * Удаляет учебную группу из потока на основе номера группы и списка студентов.
     *
     * @param groupNumber  Номер удаляемой учебной группы.
     * @param studentList  Список студентов удаляемой группы.
     */
    public void removeGroup(int groupNumber, List<Student> studentList) {
        studyGroupList.remove(new StudyGroup(groupNumber, studentList));
        groupsCount--;
    }

    /**
     * Получает список учебных групп в потоке.
     *
     * @return Список учебных групп в потоке.
     */
    public List<StudyGroup> getStudyGroupList() {
        return studyGroupList;
    }

    /**
     * Получает количество учебных групп в потоке.
     *
     * @return Количество учебных групп в потоке.
     */
    public int getGroupsCount() {
        return groupsCount;
    }

    /**
     * Получает уникальный идентификатор потока.
     *
     * @return Уникальный идентификатор потока.
     */
    public int getId() {
        return id;
    }

    /**
     * Вывод краткой информации о потоке.
     * @return ID и количество групп в потоке.
     */
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
            result.append("\n      Student Count: ").append(group.getStudentsCount()).append("\n");
        }

        result.append('\n').append("=".repeat(10)).append(" Stream Info ").append("=".repeat(10));
        return result.toString();
    }

}
