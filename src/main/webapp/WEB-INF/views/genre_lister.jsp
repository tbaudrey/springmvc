<%-- 
    Document   : effacemoi
    Created on : 23 mars 2016, 07:59:04
    Author     : tom
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value= "/resources/CSS/style2.css"/>" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lister Genre</title>
    </head>
    <body class="contenu">
        <h1>Liste des Genres </h1>
        <c:forEach items="${maListe}" var="monGenre">
            <br>
            ${monGenre.id}, ${monGenre.nom} 
            <a href="<c:url value="/genre/genre_supprimer"></c:url>/${monGenre.id}">SUPPRIMER</a>
            OU
            <a href="<c:url value="/genre/genre_modifier"></c:url>/${monGenre.id}">MODIFIER</a>
            <br>
        </c:forEach> 
            
            <a href="<c:url value="/genre/genre_ajouter"></c:url>">ajouter un genre</a>
    </body>
</html>
