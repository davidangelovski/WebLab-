package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class EventBooking {
    private String eventname;
    private String attendeeName;
    private String attendeeAddress;
    private Long numberOfTickets;
    public EventBooking() {}
    public EventBooking(String eventname, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventname = eventname;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
