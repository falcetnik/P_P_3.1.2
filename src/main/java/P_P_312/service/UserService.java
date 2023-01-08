package P_P_312.service;

import P_P_312.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteById(Long id);
}
