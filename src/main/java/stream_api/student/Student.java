package stream_api.student;

import java.util.List;

public class Student {

    private final String name;
    private List<Course> courseList;

    public Student(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    public void addCourse (Course course) {
        courseList.add(course);
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
