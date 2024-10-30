package mk.finki.ukim.mk.lab.model;

public class EventBooking {
    String eventname;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;
    public EventBooking() {}

    public EventBooking(String eventname, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventname = eventname;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getAttendeeAddress() {
        return attendeeAddress;
    }

    public void setAttendeeAddress(String attendeeAddress) {
        this.attendeeAddress = attendeeAddress;
    }

    public Long getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
