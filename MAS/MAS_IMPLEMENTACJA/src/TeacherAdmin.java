import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class TeacherAdmin extends Person implements Serializable {
    public static List<TeacherAdmin> teacherAdmins = new ArrayList<>();
    private EnumSet<EmployeeType> type;
    private List<String> qualifications;
    private int yearsWorking;
    private LocalDate dateEnrolled;
    private int coursesTaught;
    private List<Course> coursesHistory;
    private List<CourseAssignment> courseAssignments;
    private float salary;
    private float salaryBonus;
    private int levelOfAccess;
    private List<DepartmentMembership> memberships;
    private Department head;
    private List<Proficiency> languages;

    public TeacherAdmin(String firstName, String lastName, ContactData contactInfo, String gender, LocalDate dateEnrolled, float salary, float salaryBonus, List<String> qualifications) {
        super(firstName, lastName, contactInfo, gender);
        teacherAdmins.add(this);
        type = EnumSet.noneOf(EmployeeType.class);
        this.qualifications = List.copyOf(qualifications);
        this.dateEnrolled = dateEnrolled;
        yearsWorking = LocalDate.now().getYear() - dateEnrolled.getYear();
        coursesHistory = new ArrayList<>();
        coursesTaught = 0;
        this.salary = salary;
        this.salaryBonus = salaryBonus;
        memberships = new ArrayList<>();
        languages = new ArrayList<>();
        courseAssignments = new ArrayList<>();

    }

    public TeacherAdmin(String firstName, String lastName, ContactData contactInfo, LocalDate dateEnrolled, float salary, float salaryBonus, List<String> qualifications) {
        this(firstName, lastName, contactInfo, null, dateEnrolled, salary, salaryBonus, qualifications);
    }

    public void addRole(EmployeeType employeeType) {
        type.add(employeeType);
    }

    public void removeRole(EmployeeType employeeType) {
        type.remove(employeeType);
    }

    public void addQualification(String qualification) {
        qualifications.add(qualification);
    }

    public void removeQualification(String qualification) {
        qualifications.remove(qualification);
    }

    public void assign(CourseAssignment courseAssignment) throws RoleException {
        if(!type.contains(EmployeeType.TEACHER))
            throw new RoleException();
        courseAssignments.add(courseAssignment);
    }

    public void finishCourse(CourseAssignment courseAssignment) {
        courseAssignments.remove(courseAssignment);
        coursesHistory.add(courseAssignment.getCourse());
        coursesTaught++;
    }

    public void addMembership(DepartmentMembership membership) throws RoleException {
        if(!type.contains(EmployeeType.TEACHER))
            throw new RoleException();
        memberships.add(membership);
    }

    public void removeMembership(DepartmentMembership membership) {
        memberships.remove(membership);
    }

    public void setHead(Department department) {
        head = department;
    }

    public void removeHead() {
        head = null;
    }

    public void addProficiency(Proficiency proficiency) throws RoleException {
        if(!type.contains(EmployeeType.TEACHER))
            throw new RoleException();
        languages.add(proficiency);
    }

    public float getSalary() throws RoleException {
        if(isQualified()) return salary + salaryBonus;
        return salary;
    }
    public void removeProficiency(Proficiency proficiency){
        languages.remove(proficiency);
    }
    public void updateYear() {
        yearsWorking = LocalDate.now().getYear() - dateEnrolled.getYear();
    }

    public boolean isQualified() throws RoleException {
        if(!type.contains(EmployeeType.TEACHER))
            throw new RoleException();
        return coursesTaught > 20;
    }

    public void manageUser(int userID) throws RoleException {
        if(!type.contains(EmployeeType.ADMIN)) {
            throw new RoleException();
        }
        System.out.println("Managing user:");
        System.out.println(Person.users.get(userId));
    }


    public List<CourseAssignment> getCourseAssignments() {
        return courseAssignments;
    }
}
