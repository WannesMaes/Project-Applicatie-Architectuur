<%-- 
    Document   : docentreservatie
    Created on : 27-nov-2019, 13:38:46
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
            Een overzicht van de reservaties.
        </p>
        <table>
                <tr>
                    <th>Datum</th>
                    <th>Startuur</th>
                    <th>Einduur</th>
                    <th>Beschikbaar</th>
                    <th>Huurder</th>
                </tr>
            <c:forEach var="momenten" items="${applicationScope.larm}">
                <tr>
                    <td>${momenten.datum}</td>
                    <td>${momenten.startuur}</td>
                    <td>${momenten.einduur}</td>
                    <td>${momenten.beschikbaar}</td>
                    <c:if test="${momenten.beschikbaar == 'n' && !empty momenten.huurder}">
                        <td> ${momenten.huurder.getGebruikersnaam()} </td>
                    </c:if>
                </tr>
            </c:forEach>
                
        </table>
        <p>
            U heeft ook de mogelijkheid om een nieuw reservatie moment voor de machine toe te voegen.
        </p>
        <form  method="post" action="<c:url value='/URLServletC' />">
            <input type="hidden" name="waarKomIkVan" value="vanDocentReservatieNaarReservatieToevoegen">
            <input type="submit" value="Reservatie moment toevoegen">
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>