package org.example.Utils;

import org.example.Enums.EFirstName;
import org.example.Enums.ELastName;
import org.example.Study.Stream;
import org.example.Study.Student;
import org.example.Study.StudyGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoGenerate {

    /**
     * Возвращает случайное имя из списка.
     *
     * @param list Список строк, из которого выбирается случайное имя.
     * @return Случайное имя.
     */
    public static String randomFrom(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    /**
     * Создает и возвращает список строк на основе значений перечисления.
     *
     * @param enums Массив значений перечисления.
     * @return Список строк, содержащий имена элементов перечисления.
     */
    public static List<String> fillEnumsList(Enum[] enums) {
        List<String> result = new ArrayList<>();
        for (Enum anEnum : enums) result.add(anEnum.name());
        return result;
    }

    /**
     * Создает и возвращает случайного студента со случайными именем и фамилией.
     *
     * @return Случайный студент.
     */
    public static Student getRandomStudent() {
        List<String> firstNames = fillEnumsList(EFirstName.values());
        List<String> lastNames = fillEnumsList(ELastName.values());
        return new Student(randomFrom(firstNames), randomFrom(lastNames));
    }

    /**
     * Создает и возвращает список случайных студентов.
     *
     * @param count Количество студентов в списке.
     * @return Список случайных студентов.
     */
    public static List<Student> getRandomStudentList(int count) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentList.add(getRandomStudent());
        }
        return studentList;
    }

    /**
     * Создает и возвращает случайную учебную группу с указанным количеством студентов и номером группы.
     *
     * @param studentCount Количество студентов в группе.
     * @param groupNumber  Номер группы.
     * @return Случайная учебная группа.
     */
    public static StudyGroup getRandomStudyGroup(int studentCount, int groupNumber) {
        return new StudyGroup(groupNumber, getRandomStudentList(studentCount));
    }

    /**
     * Создает и возвращает список случайных учебных групп.
     *
     * @param count             Количество групп в списке.
     * @param minStudentsInGroup Минимальное количество студентов в группе.
     * @param maxStudentsInGroup Максимальное количество студентов в группе.
     * @return Список случайных учебных групп.
     */
    public static List<StudyGroup> getRandomStudyGroupList(int count, int minStudentsInGroup, int maxStudentsInGroup) {
        List<StudyGroup> studyGroupList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studyGroupList.add(getRandomStudyGroup(new Random().nextInt(minStudentsInGroup, maxStudentsInGroup), i + 100));
        }
        return studyGroupList;
    }

    /**
     * Создает и возвращает случайный поток (группу потоков) с указанными параметрами.
     *
     * @param groupsCountInStream Количество групп в потоке.
     * @param minStudentsInGroup  Минимальное количество студентов в группе.
     * @param maxStudentsInGroup  Максимальное количество студентов в группе.
     * @return Случайный поток.
     */
    public static Stream getRandomStream(int groupsCountInStream, int minStudentsInGroup, int maxStudentsInGroup) {
        return new Stream(getRandomStudyGroupList(groupsCountInStream, minStudentsInGroup, maxStudentsInGroup));
    }

    /**
     * Создаёт и возвращает список случайных потоков (групп потоков) с указанными параметрами.
     * @param streamCount Число потоков в списке.
     * @param minGroupsCountInStream Минимальное количество групп в потоке.
     * @param maxGroupsCountInStream Максимальное количество групп в потоке.
     * @param minStudentsInGroup Минимальное количество студентов в группе.
     * @param maxStudentsInGroup Максимальное количество студентов в группе.
     * @return Список случайных потоков.
     */
    public static List<Stream> getRandomStreamList(int streamCount,
                                                   int minGroupsCountInStream,
                                                   int maxGroupsCountInStream,
                                                   int minStudentsInGroup,
                                                   int maxStudentsInGroup) {
        List<Stream> streams = new ArrayList<>();
        for (int i = 0; i < streamCount; i++) {
            streams.add(getRandomStream(new Random().nextInt(minGroupsCountInStream, maxGroupsCountInStream),
                    minStudentsInGroup,maxStudentsInGroup));
        }
        return streams;
    }
}
