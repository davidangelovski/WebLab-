package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.jpa.EventRepository;
import mk.ukim.finki.lab.repository.jpa.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataHolder {
    public static Map<Long, Event> events;
    public static List<EventBooking> eventBookings;

    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;

    public DataHolder(LocationRepository locationRepository, EventRepository eventRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void init() {
        locationRepository.save(new Location(1L, "Skopje", "addr1", "2000",  "arena"));
        locationRepository.save(new Location(2L, "Ohrid", "addr2", "3000",  "amfiteatar"));
        eventRepository.save(new Event("Waidaiko-Sai", "Traditional Japanese Drums", 8.8, 1L));
    }

}
