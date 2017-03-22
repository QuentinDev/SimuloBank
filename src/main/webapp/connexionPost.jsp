<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/CSS/reset.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/CSS/global.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/CSS/content.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/CSS/jquery-ui.min.css" />" rel="stylesheet" />
	<script src="<c:url value="/resources/JS/jquery-1.10.2.min.js"/>" type="text/javascript" ></script>
	<script src="<c:url value="/resources/JS/jquery-ui.min.js"/>" type="text/javascript" ></script>
	<script src="<c:url value="/resources/JS/global.js"/>" type="text/javascript" ></script>

	<title>Comptes</title>
</head>
<body>
<div id="informations" class="sidenav shadow">
	<label>Bienvenue ${user.firstname} ${user.name}</label>
	<label>${user.email}</label>
	<label>${user.city.name}</label>
	<a class="button" href="/">Déconnexion</a>
</div>

 <div id="accountList" class="shadow">
	 <label id="title">Comptes</label>
		<c:forEach var="account" items="${user.accounts}">
			<div class="compte" id="${account.id}">
				<label>${account.id}</label>
				<label>${account.name}</label>
				<label>${account.creationDate}</label>
				<label>${account.accountType.name}</label>
				<label>${account.balance}</label>
				<form method="POST" action="/"><label><input type="text" class="date" name="final_date" size="8"><input type="hidden"name="idAccount" value="${account.id}"></label><label><input type="submit" value="Simulation"></label></form></label>
			</div>
			<div class="transactions" id="account_${account.id}">
				<table>
			<c:forEach var="transaction" items="${account.transactions}">
				<tr>
					<td>${transaction.id}</td>
					<td>${transaction.date}</td>
					<td>${transaction.libelle}</td>
					<%--<td>${transaction.transactionType.name}</td>--%>
					<td>${transaction.amount}</td>
				</tr>
			</c:forEach>
				</table>
				<form method="POST" action="/"><input type="hidden"name="idAccount" value="${account.id}"><input type="submit" value="Ajout transaction"></form>
			</div>
		</c:forEach>
	</table>
</div>

</body>
</html>
