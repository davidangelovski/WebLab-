package mk.ukim.finki.lab.repository;

import lombok.Data;
import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class EventBookingRepository {
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking booking = new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
        DataHolder.eventBookings.add(booking);
        return booking;
    }
}
