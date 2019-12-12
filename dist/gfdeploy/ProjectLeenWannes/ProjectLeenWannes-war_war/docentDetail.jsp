<%-- 
    Document   : docentDetail
    Created on : 20-nov-2019, 14:08:54
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
            Een overzicht van de machines.
        </p>
        <table>
                    <tr>
                        <th>Naam</th>
                        <th>Beschrijving</th>
                        <th>Lokaal</th>
                        <th>Opleiding</th>
                        <th>Serienummer</th>
                        <th>Aankoopprijs</th>
                        <th>Uurprijs</th>
                    </tr>
            <c:forEach var="machines" items="${applicationScope.lm}">
                <c:if test="${machines.serienr == applicationScope.sr}">
                    <tr>
                        <td>${machines.naam}</td>
                        <td>${machines.beschrijving}</td>
                        <td>${machines.lokaal}</td>
                        <td>${machines.opleiding.getNaam()}</td>
                        <td>${machines.serienr}</td>
                        <td>${machines.aankoopprijs}</td>
                        <td>${machines.uurprijs}</td>
                      
                        <c:if test ="${machines.opleiding.getNaam() == applicationScope.dop}">
                            <td>
                                <form  method="post" action="<c:url value='/URLServletC' />">
                                    <input type="hidden" name="serienr" value="${machines.serienr}">
                                    <input type="hidden" name="waarKomIkVan" value="vanDocentDetailNaarMachineWijzigen">
                                    <input type="submit" value="Wijzigen">
                                </form>
                            </td>
                        </c:if>
                    </tr>
                </c:if>
                
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
