package preProject.service;

import org.springframework.transaction.annotation.Transactional;
import preProject.dao.UserDAO;
import preProject.dao.UserDAOImpl;
import preProject.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void remove(User user) {
        userDAO.remove(user);
    }

    @Override
    public User getByNameAndPassword(String name, String password) {
        return null;
    }
}
