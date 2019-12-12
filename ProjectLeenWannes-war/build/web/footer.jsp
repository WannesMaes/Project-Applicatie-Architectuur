<%-- 
    Document   : footer
    Created on : 20-nov-2019, 13:17:46
    Author     : Wannes en Leen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  method="post" action="<c:url value='/ServletNaam.url' />">
    <input type="hidden" name="waarKomIkVan" value="8">
    <input type="submit" value="Uitloggen">
</form>