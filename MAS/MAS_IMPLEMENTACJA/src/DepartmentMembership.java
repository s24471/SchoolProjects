import java.io.Serializable;
import java.time.LocalDate;

public class DepartmentMembership implements Serializable {
    private Department department;
    private TeacherAdmin teacher;
    boolean isHead;
    public DepartmentMembership(Department department, TeacherAdmin teacher, boolean isHead) {
        this.department = department;
        this.teacher = teacher;
        try {
            teacher.addMembership(this);
            if(isHead)
                teacher.setHead(department);
            department.addMembership(this);
        } catch (RoleException e) {
            System.out.println("couldnt add to dept. person is not a teacher");
        }
    }

    public void endMembership(){
        department.removeMembership(getUserId());
        teacher.removeMembership(this);
        if(isHead)
            teacher.removeHead();
    }

    public int getUserId(){
        return teacher.userId;
    }



}
