<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/CSS/reset.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/CSS/global.css" />" rel="stylesheet" />
<title>Connexion réussie</title>
</head>
<body>
<div id="informations">
	<label>Bienvenue ${user.firstname} ${user.name}</label>
	<label>${user.email}</label>
	<label>${user.city.name}</label>
	<a class="button" href="/">Déconnexion</a>
</div>

 <div id="accountList">
	<table>
		<caption>Comptes</caption>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Date création</th>
			<th>Type</th>
			<th>Solde</th>
			<th/>
		</tr>
		<c:forEach var="account" items="${user.accounts}">
			<tr>
				<td>${account.id}</td>
				<td>${account.name}</td>
				<td>${account.creationDate}</td>
				<td>${account.accountType.name}</td>
				<td>${account.balance}</td>
				<td><form method="POST" action="/detailsAccount"><input type="hidden"name="idAccount" value="${account.id}"><input type="submit" value="Acceder"></form></td>
			</tr>

		</c:forEach>
	</table>
</div>

</body>
</html>
