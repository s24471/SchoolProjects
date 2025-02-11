import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable {
    public static List<Student> students = new ArrayList<>();
    private String pesel;
    private List<Course> courseHistory;
    private List<StudentGroup> assignedGroups;
    private List<Grade> grades;

    public Student(String firstName, String lastName, ContactData contactInfo, String gender, String pesel) {
        super(firstName, lastName, contactInfo, gender);
        students.add(this);
        courseHistory = new ArrayList<>();
        assignedGroups = new ArrayList<>();
        grades = new ArrayList<>();
        this.pesel = pesel;
    }

    public Student(String firstName, String lastName, ContactData contactInfo, String pesel) {
        this(firstName, lastName, contactInfo, null, pesel);
    }

    public void assignGroup(StudentGroup studentGroup){
        assignedGroups.add(studentGroup);
    }

    public void dropGroup(StudentGroup studentGroup){
        assignedGroups.remove(studentGroup);
        courseHistory.add(studentGroup.getCourse());
    }

    public void assignGrade(int value, int courseID){
        grades.add(new Grade(value, LocalDate.now(), courseID));
    }
    public void removeGrade(int gradeID){
        grades.remove(gradeID);
    }
    public static Student getByID(int id){
        for(Student s: students){
            if(s.userId == id)
                return s;
        }
        return null;
    }

    public List<Course> getAssignedCourses(){
        List<Course> ans = new ArrayList<>();
        for(StudentGroup studentGroup: assignedGroups){
            ans.add(studentGroup.getCourse());
        }
        return ans;
    }
    private class Grade {
        private static  int ID = 0;
        private int gradeId;
        private int value;
        private LocalDate dateAssigned;
        private int courseId;

        public Grade(int value, LocalDate dateAssigned, int courseId) {
            this.gradeId = ID++;
            this.value = value;
            this.dateAssigned = dateAssigned;
            this.courseId = courseId;
        }



    }

    @Override
    public String toString() {
        return "Student{" +
                "pesel='" + pesel + '\'' +
                ", courseHistory=" + courseHistory +
                ", assignedGroups=" + assignedGroups +
                ", grades=" + grades +
                '}';
    }
}
