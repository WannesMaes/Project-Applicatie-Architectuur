<%-- 
    Document   : reservatietoevoegen
    Created on : 5-dec-2019, 14:50:13
    Author     : Wannes en Leen
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservatie Toevoegen</title>
    </head>
    <body>
          <h1>Welkom oh zo goede prof</h1>
        <p>
           Hier kan u een reservatie moment toevoegen voor machine met serienummer <c:out value="${applicationScope.sr}" />.
        </p>
        <form  method="post" action="<c:url value='/URLServletC' />">
            <table>
                <tr>
                    <th>Label</th>
                    <th>Inhoud</th>
                </tr>
                <tr>
                    <td>Datum</td>
                    <td>
                        <input type="date" name="rdatum" value="">
                    </td>
                </tr>
                <tr>
                    <td>Startuur</td>
                    <td>
                        <input type="number" name="rstart" value="" min="8" max = "17">
                    </td>
                </tr>
                <tr>
                    <td>Einduur</td>
                    <td>
                        <input type="number" name="reind" value="" min="9" max = "18">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="waarKomIkVan" value="vanReservatieMomentToevoegenNaarDocentReservatie">
            <input type="submit" value="Reservatiemoment aanmaken">
        </form>
    </body>
</html>
