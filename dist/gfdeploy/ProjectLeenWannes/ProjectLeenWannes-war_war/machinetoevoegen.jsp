<%-- 
    Document   : machinetoevoegen
    Created on : 27-nov-2019, 13:25:12
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
           Hier kan u een machine toevoegen.
        </p>
        <form  method="post" action="<c:url value='/URLServletC' />">
            <table>
                <tr>
                    <th>Label</th>
                    <th>Inhoud</th>
                </tr>
                <tr>
                    <td>Naam</td>
                    <td>
                        <input type="text" name="mnaam" value="">
                    </td>
                </tr>
                <tr>
                    <td>Beschrijving</td>
                    <td>
                        <input type="text" name="mbeschrijving" value="">
                    </td>
                </tr>
                <tr>
                    <td>Lokaal</td>
                    <td>
                        <input type="text" name="mlokaal" value="">
                    </td>
                </tr>
                <tr>
                    <td>Opleiding</td>
                    <td>
                        <c:out value="${applicationScope.dop}"/>
                        <input type="hidden" name="mopleiding" value="${applicationScope.dop}">
                    </td>
                </tr>
                <tr>
                    <td>Serienr</td>
                    <td>
                        <input type="text" name="mserienr" value="">
                    </td>
                </tr>
                <tr>
                    <td>Aankoopprijs</td>
                    <td>
                        <input type="text" name="maankoopprijs" value="">
                    </td>
                </tr>
                <tr>
                    <td>Uurprijs</td>
                    <td>
                        <input type="text" name="muurprijs" value="">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="waarKomIkVan" value="vanMachineToevoegenNaarDocentOverzicht">
            <input type="submit" value="Machine aanmaken">
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
