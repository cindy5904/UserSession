<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 13/06/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" type="org.example.exercice6.model.Product" scope= "request"/>
<html>
<head>
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">Ajouter un produit</h1>
            <hr>
            <form action="productForm" method="post">
                <div class="mb-3">
                    <label for="marque" class="form-label">Marque:</label>
                    <input type="text" name="marque" id="marque" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="reference" class="form-label">Nom:</label>
                    <input type="text" name="reference" id="reference" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="dateAchat" class="form-label">Date d'achat:</label>
                    <input type="date" name="dateAchat" id="dateAchat" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="prix" class="form-label">Prix:</label>
                    <input type="text" name="prix" id="prix" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="stock" class="form-label">Stock:</label>
                    <input type="text" name="stock" id="stock" class="form-control">
                </div>

                <hr>
                <div class="text-end">

                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i>Envoyer</button>

                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
