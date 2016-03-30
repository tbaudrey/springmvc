<%-- 
    Document   : Ajouter_utilisateur
    Created on : 10 mars 2016, 15:13:23
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="monUtilisateur" action="inscriptionPOST" method="post">
    login :  <form:input path="login"/>
    Mdp :  <form:input path="mdp"/>
    <input type="submit"/>
</form:form>
    