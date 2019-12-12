<%-- 
    Document   : student
    Created on : 20-nov-2019, 14:03:45
    Author     : Wannes en Leen
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Welkom oh zo lieve student</h1>
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
            <c:forEach var="machines" items="${applicationScope.lm}">
                
                <tr>
                    <td>${machines.naam}</td>
                    <td>${machines.beschrijving}</td>
                    <td>${machines.lokaal}</td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${machines.serienr}">
                            <input type="hidden" name="waarKomIkVan" value="vanStudentOverzichtNaarStudentDetail">
                            <input type="submit" value="Details">
                        </form>
                    </td>
                    <td>
                        <form  method="post" action="<c:url value='/URLServletC' />">
                            <input type="hidden" name="serienr" value="${machines.serienr}">
                            <input type="hidden" name="waarKomIkVan" value="vanStudentOverzichtNaarStudentReservatie">
                            <input type="submit" value="Reserveer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>