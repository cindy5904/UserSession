<%--
  Created by IntelliJ IDEA.
  User: telci
  Date: 13/06/2024
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" type="org.example.exercice6.model.User" scope="request"/>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">Se connecter</h1>
            <hr>
            <form action="login" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" name="email" id="email" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Nom:</label>
                    <input type="text" name="name" id="name" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>

                <hr>
                <div class="text-end">

                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Se connecter</button>

                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
