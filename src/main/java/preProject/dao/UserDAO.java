package preProject.dao;

import org.springframework.security.core.userdetails.UserDetails;
import preProject.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    List getAll();

    User getById(int id);

    void update(User user);

    void remove(User user);

    User getUserByUsername(String name);

}
