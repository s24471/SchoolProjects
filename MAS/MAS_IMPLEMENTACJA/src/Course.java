import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Course implements Serializable {
    private static int ID = 0;
    public static Map<Integer, Course> courses = new HashMap<>();
    private static int minimumStudentsNumber = 15;
    private int courseId;
    private String courseName;
    private String timeStart;
    private String timeEnd;
    private List<StudentGroup> studentGroups;
    private List<Survey> surveys;
    private List<CourseAssignment> teachers;

    public Course(String courseName, String timeStart, String timeEnd) {
        this.courseId = ID++;
        courses.put(courseId, this);
        this.courseName = courseName;
        this.studentGroups = new ArrayList<>();
        this.surveys = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public void addGroup(StudentGroup group) {
        this.studentGroups.add(group);
    }

    public void removeGroup(StudentGroup group) {
        this.studentGroups.remove(group);
    }

    public void createSurvey(String title, String question){
        surveys.add(new Survey(title, question));
    }
    public void addTeacher(CourseAssignment assignment){
        teachers.add(assignment);
    }
    public void removeTeacher(CourseAssignment assignment){
        teachers.remove(assignment);
    }
    public boolean canStart(){
        return numStudents()>=minimumStudentsNumber;
    }
    public int numStudents(){
        int n = 0;
        for(StudentGroup studentGroup: studentGroups){
            n+=studentGroup.assignedStudnets();
        }
        return n;
    }
    public boolean isAssigned(int userID){
        for(StudentGroup studentGroup: studentGroups){
            if(studentGroup.contains(userID)) return true;
        }
        return false;
    }
    public boolean isTeaching(int userID){
        for(CourseAssignment courseAssignment: teachers){
            if(courseAssignment.getTeacher().userId == userID)
                return true;
        }
        return false;
    }

    public static Map<Integer, Course> getAllCourses() {
        return courses;
    }
    public static Course getCourse(int courseID){
        return courses.get(courseID);
    }
    public static List<Course> getAssignedCourses(int userID){
        List<Course> ans = new ArrayList<>();
        for(Course course: courses.values()){
            if(course.isAssigned(userID))
                ans.add(course);
        }
        return ans;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", studentGroups=" + studentGroups +
                ", surveys=" + surveys +
                ", teachers=" + teachers +
                '}';
    }

    private class Survey {
        private static int ID = 0;
        private int surveyId;
        private String title;
        private String question;
        private List<String> answers;

        public Survey(String title, String question) {
            this.surveyId = ID++;
            this.title = title;
            this.question = question;
            this.answers = new ArrayList<>();
        }

        public void conductSurvey() {

        }

        public void answer(String answer) {
            this.answers.add(answer);
        }

    }

}

