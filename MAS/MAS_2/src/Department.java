import java.util.ArrayList;
import java.util.List;

class Department {
    public List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!this.employees.contains(employee)) {
            this.employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

class Employee {
    private String name;
    private Department department;

    private Employee(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public static void addDepartment(Department department, String name){
        Employee employee = new Employee(name);
        employee.department = department;
        department.employees.add(employee);
    }
}
