package preProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import preProject.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAOImpl implements UserDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from spring_users").list();
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void remove(User user) {
        users.remove(user.getId());
    }

    @Override
    public User getByNameAndPassword(String name, String password) {
        return null;
    }
}
