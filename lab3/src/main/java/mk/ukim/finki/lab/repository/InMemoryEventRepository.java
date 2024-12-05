package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryEventRepository {
    public List<Event> findAll() {
        return DataHolder.events.values().stream().toList();
    }
    public List<Event> searchEventsByName(String text) {
        if (text.isEmpty())
            return DataHolder.events.values().stream().toList();
        else {
            return DataHolder.events.values().stream()
                    .filter(e -> e.getName().toLowerCase().contains(text.toLowerCase()))
                    .toList();
        }
    }
    public List<Event> searchEventsByPopularityScore(Integer score) {
        return DataHolder.events.values().stream()
                .filter(e -> e.getPopularityScore() >= score)
                .toList();
    }
    public void addEvent(String name, String description, double popularityScore, long locationId) {
        long id = DataHolder.events.size();
        Event event = new Event(name, description, popularityScore, ++id, locationId);
        DataHolder.events.put(id, event);
    }
    public void modifyEvent(Event event, Long id) {
        DataHolder.events.put(id, event);
    }
    public void deleteEvent(long id) {
        DataHolder.events.remove(id);
    }
    public Event getEventById(long id) {
        Event e = DataHolder.events.get(id);
        return e;
    }
    public static Event createEvent(String name, String description, double popularityScore, long locationId) {
        long id = DataHolder.events.size();
        return new Event(name, description, popularityScore, ++id, locationId);
    }
    public void like(Long eventId) {
        DataHolder.events.get(eventId).like();
    }
}
