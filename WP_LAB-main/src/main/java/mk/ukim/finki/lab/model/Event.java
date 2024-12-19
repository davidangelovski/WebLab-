package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Getter
@Table(name="events")
public class Event {

    @Id     //so ovaa anotacija atributot eventId go pretvarame vo primaren kluc
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;
    private String description;
    private double popularityScore;
    private Long locationID;
    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore, Long locationID) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.locationID = locationID;
    }

    public void like(){
        this.popularityScore+=0.1;
    }
    public Location getLocation() {
        return location;
    }
}
