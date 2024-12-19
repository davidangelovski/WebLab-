package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEventsByName(String text);
    void deleteEvent(long id);
    Event editEvent(long id);
    Event saveEvent(String name, String description, double popularityScore, Long id);
    public void modifyEvent(Event event, Long id);
    public void likeEvent(Long eventId);
}
