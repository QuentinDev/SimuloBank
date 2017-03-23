<%--
  Created by IntelliJ IDEA.
  User: maxco
  Date: 23/03/2017
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/CSS/reset.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/global.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/CSS/content.css" />" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/resources//EJSCharts-master/EJSChart.js" />"></script>
    <link href="<c:url value="/resources/CSS/jquery-ui.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/JS/jquery-1.10.2.min.js"/>" type="text/javascript" ></script>
    <script src="<c:url value="/resources/JS/jquery-ui.min.js"/>" type="text/javascript" ></script>
    <script src="<c:url value="/resources/JS/global.js"/>" type="text/javascript" ></script>
    <title>simulation</title>

</head>
<body>
<div id="informations" class="sidenav shadow">
    <label>${user.firstname} ${user.name}</label>
    <label>${user.email}</label>
    <label>${user.city.name}</label>
    <a class="button" href="/">Déconnexion</a>
</div>
<div id="accountList">
    <div id="simulator"></div>
</div>
</body>
<script>
    var chart = new EJSC.Chart("simulator",{
        show_legend: false,
        show_titlebar: false,
        title: 'Open High Low Close ' ,
        axis_bottom: new EJSC.DateAxis( {
            caption: 'Date' ,
            major_ticks: { increment: '1W' } ,
            formatter: new EJSC.DateFormatter( {
                format_string: "MMM DD"
            } )
        } ) ,
        axis_left: {
            caption: 'Prix',
            size: 60,
            formatter: new EJSC.NumberFormatter({
                currency_symbol: "€",
                currency_position: "inner",
                forced_decimals: 2
            })
        }
        });
    chart.addSeries( new EJSC.LineSeries( new EJSC.ArrayDataHandler( [
      <c:set var="bool" value="true"/>
        <c:forEach var="mtD" items="${montantDateTab}">
        <c:choose>
            <c:when test="${bool=='true'}">
                <c:set var="bool" value="false"/>

            </c:when>
            <c:otherwise>
                ,
            </c:otherwise>
            </c:choose>
        ["${mtD.date}",${mtD.montant}]
        </c:forEach>
    ] ),{legendIsVisible : false} ) );
    chart.addSeries( new EJSC.AlarmSeries( 0 , {
        color: '#cc6666',
        fill: 'down' ,
        fillTo: -500000 ,
        opacity: 20,
        flag: { visible: true }
    } ) );

</script>
<style>
    #simulator
    {
        width:70%;
        height:70%;
        margin:auto;
    }
</style>
</html>
