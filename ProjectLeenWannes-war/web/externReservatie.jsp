<%-- 
    Document   : externReservatie
    Created on : 20-dec-2019, 10:00:09
    Author     : Wannes
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserveer machine</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Reservatie uren voor de gekozen machine.</h1>
        <p>
            Een overzicht van de vrije reservatie uren van machine met serienummer <c:out value="${applicationScope.sr}" />.
        </p>
        <table>
                <tr>
                    <th>Datum</th>
                    <th>Startuur</th>
                    <th>Einduur</th>
                    <th>Beschikbaarheid</th>
                    <th>Uurprijs</th>
                    
                </tr>
            <c:forEach var="vrijrev" items="${applicationScope.lrv}">
                
                <tr>
                    <td>${vrijrev.datum}</td>
                    <td>${vrijrev.startuur}</td>
                    <td>${vrijrev.einduur}</td>
                    <td>${vrijrev.beschikbaar}</td>
                    <td>${applicationScope.up}</td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${vrijrev.serienr}">
                            <input type="hidden" name="resnr" value="${vrijrev.rnr}">
                            <input type="hidden" name="waarKomIkVan" value="vanExternReservatieNaarExternMijnReservaties">
                            <input type="submit" value="Reserveer">
                        </form>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>

