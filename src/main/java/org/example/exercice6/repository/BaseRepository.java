package org.example.exercice6.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseRepository <T>{
    protected Session session;

    public BaseRepository(Session session) {
        this.session = session;
    }
    public void create(T o){
        session.save(o);
    }

    public void update(T o){
        session.update(o);
    }

    public void delete(T o){
        session.delete(o);
    }

    abstract T findById(int id);

    abstract List<T> findAll();
}
