import java.io.Serializable;

public class ContactData implements Serializable {
    private String email;
    private String phoneNumber;

    public ContactData(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phoneNumber;
    }
}
