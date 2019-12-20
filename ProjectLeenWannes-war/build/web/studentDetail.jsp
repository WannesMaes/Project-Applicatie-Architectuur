<%-- 
    Document   : studentDetail
    Created on : 5-dec-2019, 20:59:18
    Author     : Leen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>StudentDetail</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Welkom oh zo lieve student</h1>
        <p>
            Een detailsoverzicht van de machine.
        </p>
       <table>
                    <tr>
                        <th>Naam</th>
                        <th>Beschrijving</th>
                        <th>Lokaal</th>
                        <th>Opleiding</th>
                        <th>Serienummer</th>
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
                        <td>${machines.uurprijs}</td>
                      
                        
                    </tr>
                </c:if>
                
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
