<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Connexion</title>
	<link href="<c:url value="/resources/CSS/reset.css" />" rel="stylesheet" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="<c:url value="/resources/CSS/index.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/CSS/global.css" />" rel="stylesheet" />
	</head>
<body>
	<h1>Connexion</h1>
	<br>
	<form action="/connexion" method="post">
		<div>
			<label for="email">Email</label>
			<input type="email" id="email" name="email">
		</div>

		<div>
			<label for="password">Mot de passe</label>
			<input type="password" id="password" name="password">
		</div>

		<div id="submit">
			<input type="submit" value="Se connecter">
		</div>
	</form>
	<br>

	<a href="">Inscription</a>

</body>
</html>
