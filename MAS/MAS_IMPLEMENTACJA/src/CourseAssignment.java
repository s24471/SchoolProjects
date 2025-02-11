import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseAssignment implements Serializable {
    private Course course;
    private TeacherAdmin teacher;

    public CourseAssignment(Course course, TeacherAdmin teacher) {
        this.course = course;
        this.teacher = teacher;
        try {
            if(course.isTeaching(teacher.userId))
            {
                System.out.println("This teacher is arleady teaching at this course");
                return;
            }
            for (CourseAssignment assignments : teacher.getCourseAssignments()) {
                if (assignments.getCourse().getTimeStart().equals(course.getTimeStart())) {
                    System.out.println("This teacher is already assigned to a course at the specified time");
                    return;
                }
            }
            teacher.assign(this);
            course.addTeacher(this);
        } catch (RoleException e) {
            System.out.println("couldnt assing to a course, person is not a teacher");
        }
    }

    public void endAssigment(){
        teacher.finishCourse(this);
        course.removeTeacher(this);
    }

    public Course getCourse() {
        return course;
    }

    public TeacherAdmin getTeacher() {
        return teacher;
    }

}
