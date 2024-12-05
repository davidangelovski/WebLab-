package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Event;
import mk.ukim.finki.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataHolder {
    public static Map<Long, Event> events;
    public static List<EventBooking> eventBookings;

    @PostConstruct
    public void init() {
        events = new HashMap<>();
        events.put(1000L, new Event("Summer Jazz Festival", "Enjoy live jazz music from renowned artists under the open sky", 10.00, 1000L, 2000L));
        events.put(1001L, new Event("Tech Innovation Summit", "Discover the latest advancements in AI and technology", 9.20, 1001L, 2001L));
        events.put(1002L, new Event("Gourmet Food Expo", "Taste dishes from world-class chefs and discover new culinary trends", 6.65, 1002L, 2002L));
        events.put(1003L, new Event("Yoga and Wellness Retreat", "Relax and rejuvenate with yoga sessions and wellness workshops", 8.50, 1003L, 2003L));
        eventBookings = new ArrayList<>();
//        eventList.add(new Event("Summer Jazz Festival", "Enjoy live jazz music from renowned artists under the open sky", 10.00,locationList.get(0)));
//        eventList.add(new Event("Tech Innovation Summit", " Discover the latest advancements in AI and technology",  9.20,locationList.get(1)));
//        eventList.add(new Event("Gourmet Food Expo", "Taste dishes from world-class chefs and discover new culinary trends", 6.65,locationList.get(2)));
//        eventList.add(new Event("Yoga and Wellness Retreat", " Relax and rejuvenate with yoga sessions and wellness workshops", 8.50,locationList.get(3)));
//        eventList.add(new Event("Local Art Showcase", "A collection of modern art from upcoming local artists", 5.70,locationList.get(4)));
//        eventList.add(new Event("Indie Film Screening", "Watch unique films from independent filmmakers", 7.85,locationList.get(0)));
//        eventList.add(new Event("Marathon for a Cause", " Participate in a marathon supporting community causes", 2.90,locationList.get(1)));
//        eventList.add(new Event("Book Lovers Convention", "Meet authors and attend book signings and literary talks", 1.55,locationList.get(2)));
//        eventList.add(new Event("Coding Bootcamp Weekend", "Intensive coding sessions for aspiring software developers", 10.00,locationList.get(3)));
//        eventList.add(new Event("Charity Gala Night", "A glamorous evening of dining and entertainment for a good cause", 9.30,locationList.get(4)));
    }

}
