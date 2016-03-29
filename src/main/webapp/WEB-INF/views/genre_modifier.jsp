<%-- 
    Document   : effacemoi_ajouter
    Created on : 24 mars 2016, 15:02:21
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter Genre</title>
    </head>
    <body>
        <form:form modelAttribute="monGenre" action="modifierPOST" method="post">
            <form:hidden path="id" />
            Nom :<form:input path="nom"/>
            <input type="submit"/>
        </form:form>
    </body>
</html>
