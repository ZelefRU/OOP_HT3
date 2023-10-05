package org.example.Study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student> {
    private int groupNumber;
    private List<Student> studentList = new ArrayList<>();
    private int studentsCount;

    /**
     * Конструктор для создания учебной группы с указанным номером.
     *
     * @param groupNumber Номер учебной группы.
     */
    public StudyGroup(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * Конструктор для создания пустой учебной группы.
     */
    public StudyGroup(){}

    /**
     * Конструктор для создания учебной группы с указанным номером и списком студентов.
     *
     * @param groupNumber Номер учебной группы.
     * @param studentList Список студентов в группе.
     */
    public StudyGroup(int groupNumber, List<Student> studentList) {
        this.groupNumber = groupNumber;
        this.studentList = studentList;
        studentsCount = studentList.size();
    }

    /**
     * Добавляет студента в учебную группу.
     *
     * @param student Добавляемый студент.
     */
    public void addStudent(Student student) {
        studentList.add(student);
        studentsCount++;
    }

    /**
     * Устанавливает список студентов для учебной группы.
     *
     * @param studentList Список студентов в группе.
     */
    public void addListStudents(List<Student> studentList) {
        this.studentList = studentList;
        studentsCount = studentList.size();
    }

    /**
     * Добавляет студента в учебную группу по его имени и фамилии.
     *
     * @param firstName Имя студента.
     * @param lastName  Фамилия студента.
     */
    public void addStudent(String firstName, String lastName) {
        studentList.add(new Student(firstName, lastName));
        studentsCount++;
    }

    /**
     * Удаляет студента из учебной группы.
     *
     * @param student Удаляемый студент.
     */
    public void removeStudent(Student student) {
        studentList.remove(student);
        studentsCount--;
    }

    /**
     * Удаляет студента из учебной группы по его имени и фамилии.
     *
     * @param firstName Имя студента.
     * @param lastName  Фамилия студента.
     */
    public void removeStudent(String firstName, String lastName) {
        studentList.remove(new Student(firstName, lastName));
        studentsCount--;
    }

    /**
     * Получает строковое представление учебной группы.
     *
     * @return Строковое представление учебной группы.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-".repeat(5)).append(" Students in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        int number = 1;
        for (Student student : studentList) {
            result.append("  ").append(number).append(". ").append(student.getFullName()).append("\n");
            number++;
        }
        result.append("-".repeat(5)).append(" Students in group ").append(groupNumber).append(" ").append("-".repeat(5)).append("\n");
        return result.toString();
    }

    /**
     * Получает список студентов в учебной группе.
     *
     * @return Список студентов в группе.
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Получает номер учебной группы.
     *
     * @return Номер учебной группы.
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    /**
     * Устанавливает номер учебной группы.
     *
     * @param groupNumber Номер учебной группы.
     */
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * Получает количество студентов в учебной группе.
     *
     * @return Количество студентов в группе.
     */
    public int getStudentsCount() {
        return studentsCount;
    }

    /**
     * Возвращает итератор для перебора студентов в учебной группе.
     *
     * @return Итератор для перебора студентов.
     */
    @Override
    public Iterator<Student> iterator() {
        return studentList.iterator();
    }
}

