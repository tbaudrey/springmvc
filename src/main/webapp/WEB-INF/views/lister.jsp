<%-- 
    Document   : effacemoi
    Created on : 23 mars 2016, 07:59:04
    Author     : tom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${maListe}" var="maVar">
            <br>
            <a href="<c:url value="/effacemoi/detail"></c:url>/${maVar.id}">${maVar.id}, ${maVar.nom} ${maVar.prenom}</a>
            <br>
        </c:forEach> 
            
            <a href="<c:url value="/effacemoi/ajouter"></c:url>">ajouter un effacemoi</a>
    </body>
</html>
