package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        dao.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
