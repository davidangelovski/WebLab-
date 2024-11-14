package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@WebServlet(name = "EventListServlet", urlPatterns = {"/servlet/events/events-list"})
public class EventListServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final EventServiceImpl eventService;

    public EventListServlet(SpringTemplateEngine templateEngine, EventServiceImpl eventService) {
        this.templateEngine = templateEngine;
        this.eventService = eventService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> eventList;
        String eventName = req.getParameter("eventName");
        String minRating =req.getParameter("minRating");

        if (eventName != null && minRating != null && !Objects.equals(minRating, "")) {
            eventList = eventService.listAll().stream()
                    .filter(event -> event.getName().toLowerCase().contains(eventName.toLowerCase()) ||
                            event.getDescription().toLowerCase().contains(eventName.toLowerCase()))
                    .filter(event -> event.getPopularityScore() >= Double.parseDouble(minRating))
                    .toList();
        } else if (eventName != null) {
            eventList = eventService.listAll().stream()
                    .filter(event -> event.getName().toLowerCase().contains(eventName.toLowerCase()) ||
                            event.getDescription().toLowerCase().contains(eventName.toLowerCase()))
                    .toList();
        } else if (minRating != null && !Objects.equals(minRating, "")) {
            eventList = eventService.listAll().stream()
                    .filter(event -> event.getPopularityScore() >= Double.parseDouble(minRating))
                    .toList();
        }  else {
            eventList = eventService.listAll();
        }

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("events", eventList);
        templateEngine.process("listEvents.html", context, resp.getWriter());
    }
}