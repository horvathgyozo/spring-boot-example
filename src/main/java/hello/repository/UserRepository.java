package hello.repository;

import hello.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByUsernameAndPassword(String username, String password);        
    Optional<User> findByUsername(String username);        
     
}
