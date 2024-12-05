package mk.ukim.finki.lab.service.implementation;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.repository.InMemoryEventRepository;
import mk.ukim.finki.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
    private final InMemoryEventRepository eventRepository;

    public EventServiceImplementation(InMemoryEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEventsByName(String text) {
        return eventRepository.searchEventsByName(text);
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteEvent(id);
    }

    @Override
    public Event editEvent(long id) {
        Event e = eventRepository.getEventById(id);
        return e;
    }

    @Override
    public void saveEvent(String name, String description, double popularityScore, long id) {
        eventRepository.addEvent(name, description, popularityScore, id);
    }
    @Override
    public void modifyEvent(Event event, Long eventId){
        eventRepository.modifyEvent(event, eventId);
    }

    @Override
    public void likeEvent(Long eventId) {
        eventRepository.like(eventId);
    }
}
