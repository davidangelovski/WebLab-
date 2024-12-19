//package mk.ukim.finki.lab.web.Servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.Event;
//import mk.ukim.finki.lab.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name="EventService", urlPatterns = "")
//
//public class EventListServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final EventService eventService;
//
//    public EventListServlet(SpringTemplateEngine templateEngine, EventService eventService) {
//        this.springTemplateEngine = templateEngine;
//        this.eventService = eventService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        List<Event> events = req.getSession().getAttribute("filteredEvents")==null?
//                eventService.listAll() : (List<Event>)req.getSession().getAttribute("filteredEvents");
//
//        context.setVariable("ipAddress", req.getRemoteAddr());
//        context.setVariable("attendeeName", req.getSession().getAttribute("attendeeName"));
//        context.setVariable("attendeeAddress", req.getSession().getAttribute("attendeeAddress"));
//        context.setVariable("events", events);
//
//        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String attendeeName = req.getParameter("attendeeName");
//        String attendeeAddress = req.getParameter("attendeeAddress");
//        String nameFilter = req.getParameter("eventNameFilter");
//        String ratingFilter = req.getParameter("eventRatingFilter");
//        System.out.println(nameFilter);
//        System.out.println(ratingFilter);
//
//        List<Event> filteredEvents = eventService.searchEventsByName(nameFilter);
//        req.getSession().setAttribute("filteredEvents", filteredEvents);
//        req.getSession().setAttribute("attendeeName", attendeeName);
//        req.getSession().setAttribute("attendeeAddress", attendeeAddress);
//        resp.sendRedirect("/");
////        RequestDispatcher dispatcher = req.getRequestDispatcher("/eventBooking");
////        dispatcher.forward(req, resp);
//    }
//}
