package mk.ukim.finki.lab.service.implementation;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.repository.InMemoEventRepository;
import mk.ukim.finki.lab.repository.jpa.EventRepository;
import mk.ukim.finki.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
//    private final InMemoEventRepository inMemoEventRepository;
    private final EventRepository eventRepository;


    public EventServiceImplementation(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEventsByName(String text) {
        return eventRepository.findAllByName(text);
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event editEvent(long id) {
        Event e = eventRepository.findById(id).orElse(null);
        return e;
    }

    @Override
    public Event saveEvent(String name, String description, double popularityScore, Long locationId) {
        Event e = new Event (name, description, popularityScore, locationId);
        return eventRepository.save(e);
    }
    @Override
    public void modifyEvent(Event event, Long eventId){
        eventRepository.deleteById(eventId);
        eventRepository.save(event);
    }

    @Override
    public void likeEvent(Long eventId) {
        eventRepository.findById(eventId).ifPresent(Event::like);
    }
}
