import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Person extends Guest implements Serializable {
    protected static int ID = 0;
    protected static Map<Integer, Person> users = new HashMap<>();
    protected int userId;
    protected String firstName;
    protected String lastName;
    protected ContactData contactInfo;
    protected String gender;

    public Person(String firstName, String lastName, ContactData contactInfo, String gender) {
        this.userId = ID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.gender = gender;
        users.put(userId, this);
    }
    public Person(String firstName, String lastName, ContactData contactInfo) {
        this(firstName, lastName, contactInfo, null);
    }
    public void getMyInfo() {
        System.out.println("Name: " + firstName + " " + lastName + "\nContact Info: " + contactInfo + (gender==null?"":"\nGender: "+gender));
    }
}

