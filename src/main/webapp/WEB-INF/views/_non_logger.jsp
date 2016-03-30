<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div id="non_logger">
    <td>
        <div>
            <input type="button" onclick="inscription();" value="INSCRIPTION"/>
        </div>
        
        <form:form modelAttribute="monUtilisateur" action="loginPOST" method="post">
            login :  <form:input path="login"/>
            Mdp :  <form:input path="mdp"/>
            <input type="submit"/>
        </form:form>
                
    </td> 
</div>