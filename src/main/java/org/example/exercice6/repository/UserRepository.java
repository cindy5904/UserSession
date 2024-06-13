package org.example.exercice6.repository;

import org.example.exercice6.model.Product;
import org.example.exercice6.model.User;
import org.hibernate.Session;

import java.util.List;

public class UserRepository extends BaseRepository<User> {
    public UserRepository(Session session) {
        super(session);
    }

    @Override
    public User findById(int id) {
        return (User) session.get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return session.createQuery("from User").list();
    }
}
