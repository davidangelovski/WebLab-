package mk.finki.ukim.mk.lab.web.controller;
import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events/event-booking")
public class EventBookingController {

    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }


    // Handles POST requests to save a booking
    @PostMapping
    public String saveEventBooking(
            @RequestParam String rad,
            @RequestParam String numTickets,
            Model model,
            HttpServletRequest req) {

        model.addAttribute("hostName", req.getRemoteHost());
        model.addAttribute("hostAddress", req.getRemoteAddr());
        model.addAttribute("eventName", rad);
        model.addAttribute("numOfTickets", numTickets);
        return "bookingConfirmation"; // This resolves to bookingConfirmation.html
    }
}
