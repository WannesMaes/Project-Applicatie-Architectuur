<%-- 
    Document   : extern
    Created on : 20-nov-2019, 14:03:56
    Author     : Wannes en Leen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extern</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Welkom oh zo dure externe</h1>
        <p>
            Een overzicht van de machines.
        </p>
        <table>
                <tr>
                    <th>Naam</th>
                    <th>Beschrijving</th>
                    <th>Lokaal</th>
                    <th>Details</th>
                    <th>Reservaties</th>
                </tr>
            <c:forEach var="machines" items="${lm}">
                <tr>
                    <td>${machines.naam}</td>
                    <td>${machines.beschrijving}</td>
                    <td>${machines.lokaal}</td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${machines.serienr}">
                            <input type="hidden" name="waarKomIkVan" value="vanExternOverzichtNaarExternDetail">
                            <input type="submit" value="Details">
                        </form>
                    </td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${machines.serienr}">
                            <input type="hidden" name="waarKomIkVan" value="vanExternOverzichtNaarExternReservatie">
                            <input type="submit" value="Details">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
