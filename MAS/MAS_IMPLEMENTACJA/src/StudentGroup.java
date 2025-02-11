import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentGroup implements Serializable {
    private static int ID = 0;

    private int groupId;
    private String groupName;
    private List<Student> students;
    private Course course;

    public StudentGroup(String groupName, Course course) {
        this.groupId = ID++;
        this.groupName = groupName;
        this.students = new ArrayList<>();
        this.course = course;
        course.addGroup(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.assignGroup(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public boolean contains(int userID){
        for(Student student: students){
            if(student.userId == userID) return true;
        }
        return false;
    }
    public int assignedStudnets(){
        return students.size();
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", students=" + students.size() +
                ", course=" + course.getCourseName() +
                '}';
    }
}
