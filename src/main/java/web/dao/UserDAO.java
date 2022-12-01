package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user); // create

    User getUser(long id); // read

    void removeUser(long id); // update

    void updateUser(User user); // remove

    List<User> getAllUsers();
}
