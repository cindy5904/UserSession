<%@ page import="org.example.exercice6.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 13/06/2024
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="products" type="java.util.ArrayList<org.example.exercice6.model.Product>" scope= "request"/>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
<div class="row my-3 pt-5">
    <div class="col-8 offset-2 text-bg-dark rounded p-3">
        <h1 class="fw-light text-center">✨ Liste des produits ✨</h1>
        <hr>
        <% if (!products.isEmpty()) { %>
        <table class="table table-dark text-center align-middle">
            <thead>
            <tr>
                <th>#</th>
                <th>Marque</th>
                <th>Référence</th>
                <th>Date d'Achat</th>
                <th>Prix</th>
                <th>Stock</th>
            </tr>
            </thead>
            <tbody>
            <% for (Product p : products ) { %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getMarque() %></td>
                <td><%= p.getReference() %></td>
                <td><%= p.getDateAchat() %></td>
                <td><%= p.getPrix() %> €</td>
                <td><%= p.getStock() %></td>
                <td>
                    <a href="productUpdate?id=<%= p.getId() %>" class="btn btn-info">Modifier</a>
                </td>
                <td>
                    <a href="#" class="btn btn-warning">Supprimer</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>La liste des produits est vide.</p>
        <% } %>
        <a href="productForm" class="btn btn-secondary text-center">Ajouter un produit ➕</a>
    </div>
</div>
</main>

</body>
</html>
