<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.designation}</title>
</head>
<body>
	<h1>Détail sur l'article ${article.designation}</h1>
	<br>
	Description: ${article.description}<br>
	Stock disponibe: ${article.stock}<br>
	Nombre de points requis: ${article.nbPoints}<br>

	<a href="/">Retour</a>

</body>
</html>
