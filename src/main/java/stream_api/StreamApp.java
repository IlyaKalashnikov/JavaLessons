package stream_api;

import stream_api.student.Course;
import stream_api.student.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApp {

    public List<Course> getUniqueCourses(List<Student> students) {
        return students.stream()
                .map(Student::getCourseList)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .stream().toList();
    }

    public List<Student> getSmartOnes(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(o -> o.getCourseList().size()))
                .skip(students.size() - 3)
                .toList();
    }

    public List<Student> getVisitors(List<Student> students, Course course) {
        return students.stream()
                .filter(s -> s.getCourseList().contains(course))
                .toList();
    }


}
