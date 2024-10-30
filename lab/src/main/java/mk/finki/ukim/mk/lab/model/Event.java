package mk.finki.ukim.mk.lab.model;

public class Event {
    String name;
    String description;
    double popularityScore;
    public Event() {}
    public Event(String name, String description, double popularityScore) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }
}
