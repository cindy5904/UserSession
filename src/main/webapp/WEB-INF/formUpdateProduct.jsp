<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 14/06/2024
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
    <div class="row my-3 pt-5">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light text-center">Modifier un produit</h1>
            <hr>
            <form action="productUpdate" method="post">
                <input type="hidden" name="id" value="${product.getId()}">
                <div class="mb-3">
                    <label for="marque" class="form-label">Marque</label>
                    <input type="text" class="form-control" id="marque" name="marque" value="${product.getMarque()}">
                </div>
                <div class="mb-3">
                    <label for="reference" class="form-label">Référence</label>
                    <input type="text" class="form-control" id="reference" name="reference" value="${product.getReference()}">
                </div>
                <div class="mb-3">
                    <label for="dateAchat" class="form-label">Date d'Achat</label>
                    <input type="date" class="form-control" id="dateAchat" name="dateAchat" value="${product.getDateAchat()}">
                </div>
                <div class="mb-3">
                    <label for="prix" class="form-label">Prix</label>
                    <input type="number" step="0.01" class="form-control" id="prix" name="prix" value="${product.getPrix()}">
                </div>
                <div class="mb-3">
                    <label for="stock" class="form-label">Stock</label>
                    <input type="number" class="form-control" id="stock" name="stock" value="${product.getStock()}">
                </div>
                <button type="submit" class="btn btn-primary">Enregistrer</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
