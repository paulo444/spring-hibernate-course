package com.course.Tutorials.DAO;

import com.course.Tutorials.Entities.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User getById(Integer id);
    List<User> getAll();
    void update(User user);
    void delete(int id);
}
