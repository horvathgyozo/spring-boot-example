package hello.service;

import hello.entity.User;
import hello.repository.UserRepository;
import hello.service.exception.UserNotValidException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    private User user;
    
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    
    public User register(User user) {
        return this.user = userRepository.save(user);
    }
    
    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
//        return null;
    }
    
    public void logout() {
        user = null;
    }
    
    public User getLoggedInUser() {
        return user;
    }
    
    public boolean isLoggedIn() {
        return user != null;
    }
    
    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(
                user.getUsername(), user.getPassword())
            .isPresent();
    }
}
