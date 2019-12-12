<%-- 
    Document   : machinewijzigen
    Created on : 27-nov-2019, 13:06:23
    Author     : Wannes en Leen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DocentDetail</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Welkom oh zo goede prof</h1>
        <p>
            Hier kan u de machine wijzigen.
        </p>
        
        <form  method="post" action="<c:url value='/URLServletC' />">
        <table>
            <tr>
                <th>Label</th>
                <th>Huidig</th>
                <th>Verandering</th>
            </tr>
            
            <tr>
                <td>Naam</td>
                <td>${applicationScope.machine.naam}</td>
                <td>
                    <input type="text" name="mnaam" value="${applicationScope.machine.naam}">
                </td>
            </tr>
            <tr>
                <td>Beschrijving</td>
                <td>${applicationScope.machine.beschrijving}</td>
                <td>
                    <input type="text" name="mbeschrijving" value="${applicationScope.machine.beschrijving}">
                </td>
            </tr>
            <tr>
                <td>Lokaal</td>
                <td>${applicationScope.machine.lokaal}</td>
                <td>
                        <input type="text" name="mlokaal" value="${applicationScope.machine.lokaal}">
                </td>
            </tr>
            <tr>
                <td>Opleiding</td>
                <td>${applicationScope.machine.opleiding.getNaam()}</td>
                 <td>
                        <input type="text" name="mopleiding" value="${applicationScope.machine.opleiding.getNaam()}">
                </td>
            </tr>
            <tr>
                <td>Serienr</td>
                <td>${applicationScope.machine.serienr}</td>
                <td>
                        De serienummer is niet wijzigbaar.
                        <!--input type="text" name="mserienr" value="${applicationScope.machine.serienr}"-->
                        <input type="hidden" name="mserienr" value="${applicationScope.machine.serienr}">
                </td>
            </tr>
            <tr>
                <td>Aankoopprijs</td>
                <td>${applicationScope.machine.aankoopprijs}</td>
                <td>
                        <input type="text" name="maankoopprijs" value="${applicationScope.machine.aankoopprijs}">
                </td>
            </tr>
            <tr>
                <td>Uurprijs</td>
                <td>${applicationScope.machine.uurprijs}</td>
                <td>
                        <input type="text" name="muurprijs" value="${applicationScope.machine.uurprijs}">
                </td>
            </tr>
            <tr>
                <td>
                       <input type="hidden" name="waarKomIkVan" value="vanMachineWijzigenNaarMachineDocentOverzicht">
                       <input type="submit" value="Wijzigen">
                </td>
            </tr>   
        </table>     
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
