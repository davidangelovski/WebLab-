package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="events")
public class Event {

    @Id     //so ovaa anotacija atributot eventId go pretvarame vo primaren kluc
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;
    private String description;
    private double popularityScore;
    private Long id;
    private Long locationID;
    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore, Long id, Long locationID) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.id = id;
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public Long getId() {
        return id;
    }

    public Long getLocationID() {
        return locationID;
    }
    public void like(){
        this.popularityScore+=0.1;
    }
}
