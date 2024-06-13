package org.example.exercice6.service;

import org.example.exercice6.model.Product;
import org.example.exercice6.model.User;
import org.example.exercice6.repository.ProductRepository;
import org.example.exercice6.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Product getProduct(int id){
        Product product = null;
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            product = productRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
    }

    public boolean createProduct(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    public List<Product> getProducts(){
        List<Product> products = null;
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            products = productRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return products;
    }
}
