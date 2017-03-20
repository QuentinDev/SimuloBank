<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${transaction.designation}</title>
</head>
<body>
	<h1>Détail sur l'transaction ${transaction.designation}</h1>
	<br>
	Description: ${transaction.description}<br>
	Stock disponibe: ${transaction.stock}<br>
	Nombre de points requis: ${transaction.nbPoints}<br>

	<a href="/">Retour</a>

</body>
</html>
