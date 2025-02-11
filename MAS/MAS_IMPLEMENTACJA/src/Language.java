import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Language implements Serializable {
    private String name;
    private String variation;
    private List<Proficiency> speakers;

    public Language(String name, String variation, List<Proficiency> speakers) {
        this.name = name;
        this.variation = variation;
        this.speakers = speakers;
    }

    public void addSpeaker(Proficiency proficiency){
        speakers.add(proficiency);
    }

    public void removeSpeaker(Proficiency proficiency){
        speakers.remove(proficiency);
    }
}
