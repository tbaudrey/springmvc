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
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value="/resources/JS/jquery-2.2.2.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/JS/sablier.js"/>" type="text/javascript"></script>
    </head>
    <body onload="logger()">
        <div id="logger">
            LOGGING
        </div>
        <div id="contenu">
            VIDE
        </div>
        <div id="pied">Copyright</div>
    </body>
</html>

