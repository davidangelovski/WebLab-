package mk.ukim.finki.lab.web.Controllers;

import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String firstName,
                           HttpSession session,
                           Model model) {
        if(username.isEmpty() || password.isEmpty() || firstName.isEmpty()) {
            model.addAttribute("error", "Username, password and name are required.");
            return "login";
        }
        try {
            User user = authService.register(username, password, firstName);
            session.setAttribute("user", user);
            return "redirect:/events";
        }catch(UserAlreadyExistsException e){
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}
