<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>
	<h1>Inscription</h1>
	<br>
	<form action="/inscription" method="post">
		<div>
			<label for="NOM">Nom</label>
			<input accountType="text" id="NOM" name="NOM">
		</div>

		<div>
			<label for="PRENOM">Prenom</label>
			<input accountType="text" id="PRENOM" name="PRENOM">
		</div>

		<div>
			<label for="EMAIL">Email</label>
			<input accountType="email" id="EMAIL" name="EMAIL">
		</div>

		<div>
			<label for="MOT_DE_PASSE">Mot de passe</label>
			<input accountType="password" id="MOT_DE_PASSE" name="MOT_DE_PASSE">
		</div>
		<select name="CITY">

            <c:forEach var="city" items="${cities}">
                <option id="${city.name}" value="${city.id}">${city.name}</option>
                <label for="${city.name}">${city.name}</label>
            </c:forEach>

        </select>
		<div>
			<input accountType="submit" value="S'inscrire">
		</div>
	</form>
	<br>

	<a href="/">Retour</a>

</body>
</html>
