package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;
    private List<String> studentList;
    private List<Level> level;

    Course(String name){
        this.name = name;
        this.studentList = new ArrayList<>();
        this.level = List.of(Level.LEVEL1,Level.LEVEL2,Level.LEVEL3,
                Level.LEVEL4,Level.LEVEL5);
    }

    public static void updateNewStudents(Course course, List<String> studentList){
        course.studentList.addAll(studentList);
    }

    public static String getName(Course course){
        return course.name;
    }

    public static List<String> getStudentList(Course course){
        return course.studentList;
    }

    public static Course findCourseByName(String courseName){
        for(Course course : Course.values()){
            if(course.name.equals(courseName)){
                return course;
            }
        }
        return null;
    }
}
