<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/CSS/reset.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/global.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/content.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/jquery-ui.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/bootstrap-theme.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/JS/jquery-1.10.2.min.js"/>" type="text/javascript" ></script>
    <script src="<c:url value="/resources/JS/jquery-ui.min.js"/>" type="text/javascript" ></script>
    <script src="<c:url value="/resources/JS/global.js"/>" type="text/javascript" ></script>
    <script src="<c:url value="/resources/JS/bootstrap.min.js"/>" type="text/javascript" ></script>

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
    <c:forEach var="account" items="${accounts}">
        <div class="compte" id="${account.id}">
            <c:set var="string1" value="${account.creationDate}"/>
            <c:set var="string2" value="${fn:split(string1, ' ')}" />
            <c:set var="date_creation" value="${fn:split(string2[0], '-')}" />
            <label>${account.id}</label>
            <label>${account.name}</label>
            <label>${date_creation[2]}/${date_creation[1]}/${date_creation[0]}</label>
            <label>${account.accountType.name}</label>
            <label>${account.balance}</label>
            <form method="POST" action="/simulation">
                <label>
                    <input type="text" class="date" name="final_date" size="8">
                    <input type="hidden"name="idAccount" value="${account.id}">
                </label>
                <label>
                    <input type="submit" value="Simulation">
                </label>
            </form>
        </div>
        <div class="transactions" id="account_${account.id}">
            <table>
                <c:forEach var="transaction" items="${account.transactions}">
                    <c:set var="string1" value="${transaction.date}"/>
                    <c:set var="string2" value="${fn:split(string1, ' ')}" />
                    <c:set var="date" value="${fn:split(string2[0], '-')}" />
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${date[2]}/${date[1]}/${date[0]}</td>
                        <td>${transaction.transactionType.name}</td>

                        <td>${transaction.libelle}</td>
                            <%--<td>${transaction.transactionType.name}</td>--%>
                        <td>${transaction.amount}</td>
                    </tr>
                </c:forEach>
                <c:if test="${account.transactions.size() == 0}">
                    <p>Aucune transaction disponible.</p>
                </c:if>
            </table>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal${account.id}">
                Créer une transaction
            </button>
            <!-- Modal -->
            <div class="modal fade" id="myModal${account.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Créer une transaction</h4>
                        </div>
                        <div class="modal-body">
                            <form action="/createTransaction" method="post">
                                <div>
                                    <input type="hidden" id="ACCOUNT_ID" name="ACCOUNT_ID" value="${account.id}">
                                </div>

                                <div class="form-group">
                                    <label for="NAME">Nom de la transaction</label>
                                    <input required type="text" id="NAME" name="NAME">
                                </div>

                                <div class="form-group">
                                    <label for="AMOUNT">Montant de la transaction</label>
                                    <input required type="number" id="AMOUNT" name="AMOUNT" step="any">
                                </div>

                                <div class="form-group">
                                    <label for="DATE">Date de la transaction</label>
                                    <input required type="date" id="DATE" name="DATE">
                                </div>

                                <label for="TRANSACTIONTYPE">Type de la transaction</label>
                                <select name="TRANSACTIONTYPE" class="form-group">
                                    <c:forEach var="type" items="${transactionTypes}">
                                        <option id="${type.name}" value="${type.id}">${type.name}</option>
                                        <label for="${type.name}">${type.name}</label>
                                    </c:forEach>
                                </select>

                                <div id="submit">
                                    <input Type="submit" value="Ajouter la transaction">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>

<div class="sidenav shadow">
    <p>Créer un compte :</p>
    <form action="/createAccount" method="post">
        <div class="form-group">
            <label for="NAME">Nom de compte</label>
            <input required type="text" id="NAME" name="NAME">
        </div>

        <div class="form-group">
            <label for="BALANCE">Solde de départ (en €)</label>
            <input required type="number" id="BALANCE" name="BALANCE" step="any">
        </div>

        <label for="ACCOUNTTYPE">Type du compte</label>
        <select name="ACCOUNTTYPE" class="form-group">
            <c:forEach var="type" items="${accountTypes}">
                <option id="${type.name}" value="${type.id}">${type.name}</option>
                <label for="${type.name}">${type.name}</label>
            </c:forEach>
        </select>

        <div id="submit">
            <input Type="submit" value="Ajouter le compte">
        </div>
    </form>
</div>

</body>
</html>
