package su.alexmcgil.crud_boot.service;

import su.alexmcgil.crud_boot.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
}
