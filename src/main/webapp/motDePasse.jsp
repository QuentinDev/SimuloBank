<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 10/02/2017
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password reset</title>
</head>
<body>
    <h1>Password reset</h1>
    <br>
    <form action="/passwordReset" method="post">
        <div>
            <label for="email">Email</label>
            <input type="email" id="email" name="email">
        </div>

        <div>
            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password">
        </div>

        <div>
            <input type="submit" value="Changer le mot de passe">
        </div>
    </form>
    <br>

    <a href="/">Retour</a>
</body>
</html>
