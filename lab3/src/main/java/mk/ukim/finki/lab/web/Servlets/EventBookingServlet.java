//package mk.ukim.finki.lab.web.Servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.EventBooking;
//import mk.ukim.finki.lab.service.EventBookingService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name="EventBooking", urlPatterns="/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//    SpringTemplateEngine springTemplateEngine;
//    private final EventBookingService eventBookingService;
//
//    public EventBookingServlet(EventBookingService eventBookingService, SpringTemplateEngine springTemplateEngine) {
//        this.eventBookingService = eventBookingService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    public void init() throws ServletException {
//        getServletContext().setAttribute("bookedEvents", new ArrayList<EventBooking>());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        String eventName = req.getParameter("eventName");
//        String attendeeName =(String) req.getSession().getAttribute("attendeeName");
//        String attendeeAddress =(String) req.getSession().getAttribute("attendeeAddress");
//        Integer numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));
//
//        EventBooking eventBooking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
//
//        context.setVariable("booking", eventBooking);
//        context.setVariable("clientIP", req.getRemoteAddr());
//
//        List<EventBooking> bookings = (ArrayList<EventBooking>) getServletContext().getAttribute("bookedEvents");
//        bookings.add(eventBooking);
//        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//    }
//}
