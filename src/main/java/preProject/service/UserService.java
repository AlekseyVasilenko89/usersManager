package preProject.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import preProject.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> getAll();

    User getById(int id);

    void update(User user);

    void remove(User user);
}
