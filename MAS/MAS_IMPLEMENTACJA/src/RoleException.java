import java.io.Serializable;

public class RoleException extends Exception implements Serializable {
    @Override
    public String getMessage() {
        return "Given person does not have required roles to execute the task";
    }
}
