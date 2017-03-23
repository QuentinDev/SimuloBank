<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quentin
  Date: 21/03/2017
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des comptes</title>
</head>
<body>
<c:forEach var="account" items="${accounts}">
    <p>${account.name} : ${account.balance}€</p>
    <br>
    <c:forEach var="transaction" items="${account.transactions}">
        <p>${transaction.amount} / ${transaction.libelle} / ${transaction.date} / ${transaction.transactionType.name}</p>
    </c:forEach>
    <c:if test="${account.transactions.size() == 0}">
        <p>Aucune transaction disponible.</p>
    </c:if>
    <p>Rajouter une transaction :</p>
    <form action="/createTransaction" method="post">
        <div>
            <input type="hidden" id="ACCOUNT_ID" name="ACCOUNT_ID" value="${account.id}">
        </div>

        <div>
            <label for="NAME">Nom de la transaction</label>
            <input required type="text" id="NAME" name="NAME">
        </div>

        <div>
            <label for="AMOUNT">Montant de la transaction</label>
            <input required type="number" id="AMOUNT" name="AMOUNT">
        </div>

        <div>
            <label for="DATE">Date de la transaction</label>
            <input required type="date" id="DATE" name="DATE">
        </div>

        <label for="TRANSACTIONTYPE">Type de la transaction</label>
        <select name="TRANSACTIONTYPE">
            <c:forEach var="type" items="${transactionTypes}">
                <option id="${type.name}" value="${type.id}">${type.name}</option>
                <label for="${type.name}">${type.name}</label>
            </c:forEach>
        </select>

        <div id="submit">
            <input Type="submit" value="Ajouter la transaction">
        </div>
    </form>
    <hr>
</c:forEach>


<p>Créer un compte :</p>
<form action="/createAccount" method="post">
    <div>
        <input type="hidden" id="USER_ID" name="USER_ID" value="${user.id}">
    </div>
    <div>
        <label for="NAME">Nom de compte</label>
        <input required type="text" id="NAME" name="NAME">
    </div>

    <div>
        <label for="BALANCE">Solde de départ (en €)</label>
        <input required type="text" id="BALANCE" name="BALANCE">
    </div>

    <label for="ACCOUNTTYPE">Type du compte</label>
    <select name="ACCOUNTTYPE">
        <c:forEach var="type" items="${accountTypes}">
            <option id="${type.name}" value="${type.id}">${type.name}</option>
            <label for="${type.name}">${type.name}</label>
        </c:forEach>
    </select>

    <div id="submit">
        <input Type="submit" value="Ajouter le compte">
    </div>
</form>


</body>
</html>
