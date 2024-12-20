package mk.ukim.finki.lab.web.Controllers;

import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.repository.InMemoryEventRepository;
import mk.ukim.finki.lab.repository.InMemoryLocationRepository;
import mk.ukim.finki.lab.service.EventService;
import mk.ukim.finki.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;
    private final InMemoryEventRepository eventRepository;
    private final InMemoryLocationRepository locationRepository;

    public EventController(EventService eventService, LocationService locationService, InMemoryEventRepository eventRepository, InMemoryLocationRepository locationRepository) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }
    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);
        model.addAttribute("locations", locationRepository.findAll());
        return "listEvents";
    }
    @PostMapping
    public String filterEvents(@RequestParam String eventNameFilter,
                               @RequestParam double eventRatingFilter,
                               Model model){
        List<Event> filteredEvents = eventService.listAll()
                .stream()
                .filter(event -> event.getName().equals(eventNameFilter) && event.getPopularityScore()>=eventRatingFilter)
                .toList();
        model.addAttribute("events", filteredEvents);
        model.addAttribute("locations", locationRepository.findAll());
        return "listEvents";
    }
    @GetMapping("/add-event")
    public String displayAddEventForm(Model model, @RequestParam(required = false) String error) {
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("error", error);
        return "add-event";
    }

    @PostMapping("/add-event")
    public String saveEvent(@RequestParam String eventName,
                            @RequestParam String description,
                            @RequestParam String popularityScore,
                            @RequestParam Long locationId,
                            @RequestParam (required = false) Long eventId){
        if(eventId!=null){
            Event modified = new Event(eventName, description, Double.parseDouble(popularityScore), eventId, locationId);
            eventService.modifyEvent(modified, eventId);
        }
        else {
            eventService.saveEvent(eventName, description, Double.parseDouble(popularityScore), locationId);
        }
        return "redirect:/events";
    }
    @GetMapping("/edit/{eventId}")
    public String editEvent(Model model, @PathVariable String eventId) {
        Event event = eventRepository.getEventById(Long.parseLong(eventId));
        model.addAttribute("event", event);
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("selectedLocation", locationService.findById(event.getLocationID()));

        return "add-event";
    }
    @PostMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable String eventId) {
        eventService.deleteEvent(Long.parseLong(eventId));
        return "redirect:/events";
    }
    @PostMapping("/like/{eventId}")
    public String likeEvent(@PathVariable String eventId) {
        eventService.likeEvent(Long.parseLong(eventId));
        return "redirect:/events";
    }
}
