package com.course.Tutorials.DAO;

import com.course.Tutorials.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOMain implements UserDAO {

    EntityManager entityManager;

    @Autowired
    public UserDAOMain(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> typedQuery = entityManager.createQuery("FROM User", User.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
