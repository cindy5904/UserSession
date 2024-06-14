package org.example.exercice6.repository;

import org.example.exercice6.model.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository extends BaseRepository<Product> {

    public ProductRepository(Session session) {
        super(session);
    }

    @Override
    public void create(Product product) {
        session.save(product); // Ou session.persist(product) pour une insertion
    }

    @Override
    public void update(Product product) {
        session.update(product);
    }

    @Override
    public void delete(Product product) {
        session.delete(product);
    }

    @Override
    public Product findById(int id) {
        return session.get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return session.createQuery("from Product", Product.class).list();
    }
}
