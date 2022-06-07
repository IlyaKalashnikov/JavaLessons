package stream_api_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream_api.StreamApp;
import stream_api.student.Course;
import stream_api.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StreamAppTest {
    Student student1 = new Student("Ivan", new ArrayList<>());
    Student student2 = new Student("Ilya", new ArrayList<>());
    Student student3 = new Student("Igor", new ArrayList<>());
    Student student4 = new Student("Egor", new ArrayList<>());
    Student student5 = new Student("Evgeniy", new ArrayList<>());

    List<Student> students = new ArrayList<>();

    StreamApp app = new StreamApp();

    @BeforeEach
    void addCourses () {
        student1.addCourse(Course.MATH);
        student1.addCourse(Course.LITERATURE);
        student1.addCourse(Course.ENGLISH);

        student2.addCourse(Course.MATH);
        student2.addCourse(Course.ENGLISH);

        student3.addCourse(Course.MATH);
        student3.addCourse(Course.HISTORY);
        student3.addCourse(Course.ENGLISH);

        student4.addCourse(Course.MATH);
        student4.addCourse(Course.PHILOSOPHY);
        student4.addCourse(Course.ENGLISH);
        student4.addCourse(Course.HISTORY);

        student5.addCourse(Course.MATH);
        student5.addCourse(Course.LITERATURE);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    @Test
    void getUniqueCourses_ShouldReturnUniqueCoursesSet () {
        List<Course> list = app.getUniqueCourses(students);
        Assertions.assertTrue(list.size() == 5);
    }

    @Test
    void getSmartOnes_ShouldReturnThreeStudentsWithMostCourses(){
        List<Student> list = app.getSmartOnes(students);
        Assertions.assertTrue(list.contains(student1) && list.contains(student3) && list.contains(student4));
    }

    @Test
    void getVisitors_ShouldReturnVisitorsOfCourse () {
        List<Student> list = app.getVisitors(students, Course.PHILOSOPHY);
        Assertions.assertTrue(list.size() == 1);
    }



}
