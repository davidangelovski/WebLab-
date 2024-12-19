package mk.ukim.finki.lab.web.Controllers;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab.exceptions.BadLoginCredentialsException;
import mk.ukim.finki.lab.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String getLoginPage() {
        System.out.println("At login");
        return "login";
    }
    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("Authenticating");
        if (username != null && password != null) {
            try {
                User user = authService.login(username, password);
                session.setAttribute("user", user);
                return "redirect:/events";
            } catch (BadLoginCredentialsException e) {
                model.addAttribute("error", e.getMessage());
                return "login";
            }catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "access-denied";
            }
        } else {
            model.addAttribute("error", "Username or password is missing.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
