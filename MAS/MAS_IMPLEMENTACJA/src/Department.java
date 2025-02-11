import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department implements Serializable {
    private int departmentId;
    private String departmentName;
    private TeacherAdmin head;
    private Map<Integer, DepartmentMembership> memberships;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.memberships = new HashMap<>();
    }

    public void addMembership(DepartmentMembership membership) {
        memberships.put(membership.getUserId(), membership);
    }

    public void removeMembership(int userId){
        memberships.remove(userId);
    }

    public void setHead(TeacherAdmin teacher){
        if(!memberships.containsKey(teacher.userId))
        {
            System.out.println("Cant appoint teacher not part of a dept as a head");
            return;
        }
        head = teacher;

    }
}
