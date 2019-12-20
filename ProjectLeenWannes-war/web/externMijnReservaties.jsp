<%-- 
    Document   : externMijnReservaties
    Created on : 20-dec-2019, 10:14:04
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
        <h1>Uw reservaties</h1>
        <p>
            Een overzicht van de machines met een reservatie van u.
        </p>
        <table>
                <tr>
                    <th>Datum</th>
                    <th>Startuur</th>
                    <th>Einduur</th>
                    <th>Uurprijs</th>
                    <th>Totale prijs</th>
                    <th>Annuleren</th>
                    
                </tr>
            <c:forEach var="mijnrev" items="${applicationScope.mrv}">
                
                <tr>
                    <td>${mijnrev.datum}</td>
                    <td>${mijnrev.startuur}</td>
                    <td>${mijnrev.einduur}</td>
                    <td>${mijnrev.getUurprijs(mijnrev.rnr)}</td>
                    <td>${((mijnrev.einduur-mijnrev.startuur)*applicationScope.upr)}</td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${mijnrev.serienr}">
                            <input type="hidden" name="resnr" value="${mijnrev.rnr}">
                            <input type="hidden" name="waarKomIkVan" value="vanExternMijnReservatiesNaarExternMijnReservaties">
                            <input type="submit" value="Annuleer">
                        </form>
                    </td>
                   
                </tr>
            </c:forEach>
        </table>
        <c:forEach var="i" begin="0" end="${applicationScope.mrv.size()}">
            Item <c:out value = "${i}"/>
        </c:forEach>
        <jsp:include page="footer.jsp" />
    </body>
</html>
