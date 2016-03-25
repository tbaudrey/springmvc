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
        <title>JSP Page</title>
    </head>
    <body>
        <form:form modelAttribute="monEffaceMoi" action="ajouterPOST" method="post">
            Nom :<form:input path="nom"/>
            Prenom :<form:input path="prenom"/>
            <input type="submit"/>
        </form:form>
    </body>
</html>
