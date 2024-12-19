package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public User login(String username, String password);
    public User register(String username, String password, String firstName);
}
