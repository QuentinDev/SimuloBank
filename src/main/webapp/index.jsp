<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Articles</title>
</head>
<body>
	<h1>Liste des Articles</h1>
	<br>
	<form action="catalogueFiltre" method="get">
		<input accountType="number" name="POINT_MIN" placeholder="Valeur minimum de points"/>
		<input accountType="number" name="POINT_MAX" placeholder="Valeur minimum de points"/>
		<input accountType="submit" value="Filtrer"/>
	</form>
	<c:forEach var="article" items="${articles}">
		<hr>
		<h2>${article.designation}</a> (${article.categorie.nom})
		</h2>
		<a href="detailArticle?ID_ARTICLE=${article.idArticle}">Détails sur l'article</a>
		<hr>
	</c:forEach>
	<br>
	<br>
	<p>Nombre total d'article(s): ${articles.size()}</p>

	<a href="/inscription">S'inscrire</a>
	<a href="/connexion">Se connecter</a>
	<a href="/passwordReset">Changer mot de passe</a>
</body>
</html>
