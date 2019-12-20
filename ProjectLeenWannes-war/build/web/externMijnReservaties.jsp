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
                    <th>Serienummer</th>
                    <th>Totale prijs</th>
                    <th>Annuleren</th>
                    
                </tr>
        <c:if test="${applicationScope.mrv.size() > 0}">
            <c:forEach var="i" begin="0" end="${applicationScope.mrv.size()-1}">
                <tr>
                    <td>${applicationScope.mrv.get(i).datum}</td>
                    <td>${applicationScope.mrv.get(i).startuur}</td>
                    <td>${applicationScope.mrv.get(i).einduur}</td>
                    <td>${applicationScope.lpr.get(i)}</td>
                    <td>${applicationScope.mrv.get(i).serienr.getSerienr()}</td>
                    <td>${((applicationScope.mrv.get(i).einduur-applicationScope.mrv.get(i).startuur)*applicationScope.lpr.get(i))}</td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${applicationScope.mrv.get(i).serienr}">
                            <input type="hidden" name="resnr" value="${applicationScope.mrv.get(i).rnr}">
                            <input type="hidden" name="waarKomIkVan" value="vanExternMijnReservatiesNaarExternMijnReservaties">
                            <input type="submit" value="Annuleer">
                        </form>
                    </td>
                   
                </tr>
            </c:forEach>
        </c:if>
            
        </table>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
