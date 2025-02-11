import java.io.Serializable;

public class Proficiency implements Serializable {
    private TeacherAdmin teacher;
    private Language language;
    private ProficiencyLevel level;

    public Proficiency(TeacherAdmin teacher, Language language, ProficiencyLevel level) {
        this.teacher = teacher;
        this.language = language;
        this.level = level;

        try {
            teacher.addProficiency(this);
            language.addSpeaker(this);
        } catch (RoleException e) {
            System.out.println("Couldnt add proficiency to a person since its not a teacher");
        }

    }

    public void removeProf(){
        teacher.removeProficiency(this);
        language.removeSpeaker(this);
    }

    public enum ProficiencyLevel {
        A1, A2, B1, B2, C1, C2, NATIVE_SPEAKER;
    }

}
