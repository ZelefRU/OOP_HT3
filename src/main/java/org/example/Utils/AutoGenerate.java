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

    public static String randomFrom(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static List<String> fillEnumsList(Enum[] enums) {
        List<String> result = new ArrayList<>();
        for (Enum anEnum : enums) result.add(anEnum.name());
        return result;
    }

    public static Student getRandomStudent() {
        List<String> firstNames = fillEnumsList(EFirstName.values());
        List<String> lastNames = fillEnumsList(ELastName.values());
        return new Student(randomFrom(firstNames), randomFrom(lastNames));
    }

    public static List<Student> getRandomStudentList(int count) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentList.add(getRandomStudent());
        }
        return studentList;
    }

    public static StudyGroup getRandomStudyGroup(int studentCount, int groupNumber) {
        return new StudyGroup(groupNumber, getRandomStudentList(studentCount));
    }

    public static List<StudyGroup> getRandomStudyGroupList(int count, int minStudentsInGroup, int maxStudentsInGroup) {
        List<StudyGroup> studyGroupList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studyGroupList.add(getRandomStudyGroup(new Random().nextInt(minStudentsInGroup, maxStudentsInGroup), i + 100));
        }
        return studyGroupList;
    }

    public static Stream getRandomStream(int groupsCountInStream, int minStudentsInGroup, int maxStudentsInGroup) {
        return new Stream(getRandomStudyGroupList(groupsCountInStream, minStudentsInGroup, maxStudentsInGroup));
    }

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
