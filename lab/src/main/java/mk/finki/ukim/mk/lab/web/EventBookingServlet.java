package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "EventBookingServlet", urlPatterns = {"/EventBooking"})
public class EventBookingServlet extends HttpServlet {

    private final EventService eventService;
    private final SpringTemplateEngine templateEngine;

    public EventBookingServlet(EventService eventService, SpringTemplateEngine templateEngine) {
        this.eventService = eventService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String eventName = req.getParameter("choose");
        String numOfTickets = req.getParameter("numTickets");

        IWebExchange iWebExchange = JakartaServletWebApplication.buildApplication(req.getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("hostName", req.getRemoteHost());
        context.setVariable("hostAddress", req.getRemoteAddr());
        context.setVariable("eventName", eventName);
        if(!Objects.equals(numOfTickets, "")) {
            context.setVariable("numOfTickets", numOfTickets);
        }
        templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
    }
}