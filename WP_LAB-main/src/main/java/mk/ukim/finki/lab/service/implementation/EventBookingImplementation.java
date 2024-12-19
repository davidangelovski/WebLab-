package mk.ukim.finki.lab.service.implementation;

import mk.ukim.finki.lab.model.EventBooking;
import mk.ukim.finki.lab.repository.EventBookingRepository;
import mk.ukim.finki.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingImplementation implements EventBookingService {
    private final EventBookingRepository bookingRepository;

    public EventBookingImplementation(EventBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return bookingRepository.placeBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }
}
