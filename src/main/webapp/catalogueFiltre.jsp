<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 10/02/2017
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalogue filtré</title>

    <c:forEach var="article" items="${articles}">
        <hr>
        <h2>${article.designation}</a> (${article.categorie.nom})
        </h2>
        <a href="detailArticle?ID_ARTICLE=${article.idArticle}">Détails sur l'article</a>
        <hr>
    </c:forEach>
</head>
<body>

</body>
</html>
