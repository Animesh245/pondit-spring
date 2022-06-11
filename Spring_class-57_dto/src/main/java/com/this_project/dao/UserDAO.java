package com.this_project.dao;

import com.this_project.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDAO {
    Long saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getUserList();

    User getUserById(Long id);
}
