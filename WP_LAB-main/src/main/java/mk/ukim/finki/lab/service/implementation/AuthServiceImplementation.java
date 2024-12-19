package mk.ukim.finki.lab.service.implementation;

import mk.ukim.finki.lab.exceptions.BadLoginCredentialsException;
import mk.ukim.finki.lab.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.repository.jpa.UserRepository;
import mk.ukim.finki.lab.service.AuthService;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImplementation implements AuthService {
    UserRepository userRepository;

    public AuthServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(BadLoginCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String firstName) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(new User(username, password, firstName));
    }
}
