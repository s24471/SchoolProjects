import java.util.HashMap;
import java.util.Map;

class Student {
    private String id;
    public Map<Course, Enrollment> courses;

    public Student(String id) {
        this.id = id;
        this.courses = new HashMap<>();
    }

    public void enrollInCourse(Course course, String semester) {
        Enrollment enrollment = new Enrollment(this, course, semester);
        this.courses.put(course, enrollment);
        course.getEnrollments().put(this, enrollment);
    }

    public Map<Course, Enrollment> getCourses() {
        return courses;
    }
}

class Course {
    private String code;
    private Map<Student, Enrollment> enrollments;

    public Course(String code) {
        this.code = code;
        this.enrollments = new HashMap<>();
    }

    public void enrollStudent(Student student, String semester){
        Enrollment enrollment = new Enrollment(student, this, semester);
        student.courses.put(this, enrollment);
        this.getEnrollments().put(student, enrollment);
    }

    public Map<Student, Enrollment> getEnrollments() {
        return enrollments;
    }
}

class Enrollment {
    private Student student;
    private Course course;
    private String semester;

    public Enrollment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }
}
