package org.example.exercice6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.exercice6.model.Product;
import org.example.exercice6.service.ProductService;
import org.example.exercice6.util.HibernateSession;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet(name="product", value= {"/productList", "/productForm", "/productUpdate"})
public class ProductServlet extends HttpServlet {
        private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path){
            case "/productList":
                listProducts(req,resp);
                break;
            case "/productForm":
                formProduct(req,resp);
                break;
            case "/productUpdate":
                updateProduct(req,resp);
                break;
            default:
                resp.sendRedirect("erreur");
                break;
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String marque = req.getParameter("marque");
        String reference = req.getParameter("reference");
        LocalDate dateAchat = LocalDate.parse(req.getParameter("dateAchat"));
        double prix = Double.parseDouble(req.getParameter("prix"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        String uploadPath = getServletContext().getRealPath("/") + "image";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }

        Part image = req.getPart("image");
        String fileName = image.getSubmittedFileName();
        image.write(uploadPath + File.separator + fileName);

        String imageUrl = req.getContextPath() + "/image/" + fileName;

        if (idStr != null && !idStr.isEmpty()) {

            Product product = new Product( marque, reference, dateAchat, prix, stock, imageUrl);
            productService.updateProduct(product);
        } else {
            Product product = new Product(marque, reference, dateAchat, prix, stock, imageUrl);
            productService.createProduct(product);
        }

        resp.sendRedirect("productList");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProduct(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/formUpdateProduct.jsp").forward(req, resp);
    }

    private void formProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/productForm.jsp").forward(req, resp);
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/productListe.jsp").forward(req, resp);
    }
}
