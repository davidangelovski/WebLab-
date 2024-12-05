//package mk.ukim.finki.lab.web.Servlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.lab.model.EventBooking;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@WebServlet(name="EventsBookedServlet", urlPatterns = "/bookings")
//public class EventsBookedServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventsBookedServlet(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
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
//        Object bookedEvents = (ArrayList<EventBooking>)getServletContext().getAttribute("bookedEvents");
//
//        context.setVariable("bookedEvents", bookedEvents);
//
//        springTemplateEngine.process("bookedEvents.html", context, resp.getWriter());
//    }
//}
