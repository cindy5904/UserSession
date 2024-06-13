package org.example.exercice6.service;

import org.example.exercice6.model.User;
import org.example.exercice6.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(int id){
        User user = null;
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            user = userRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    public List<User> getUsers(){
        List<User> users = null;
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            users = userRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return users;
    }
    public User authenticate(String email, String password) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
