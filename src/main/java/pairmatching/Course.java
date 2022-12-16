package pairmatching;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Course {
    BACKEND("백앤드"),
    FRONTEND("프론트엔드");

    private String name;
    private Set<String> studentList;

    Course(String name){
        this.name = name;
        this.studentList = new HashSet<>();
    }

    public static void updateNewStudents(Course course, List<String> studentList){
        course.studentList.addAll(studentList);
    }
}
