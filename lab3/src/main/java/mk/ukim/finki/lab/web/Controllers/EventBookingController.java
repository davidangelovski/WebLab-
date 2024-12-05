package mk.ukim.finki.lab.web.Controllers;

import mk.ukim.finki.lab.model.EventBooking;
import org.springframework.ui.Model;
import mk.ukim.finki.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/events/booking")
public class EventBookingController {
    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @PostMapping
    public String bookEvent(Model model,
                            @RequestParam String attendeeName,
                            @RequestParam String eventName,
                            @RequestParam String attendeeAddress,
                            @RequestParam Integer numTickets){
        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets);
        model.addAttribute("booking", booking);
        return "bookingConfirmation";
    }
}
