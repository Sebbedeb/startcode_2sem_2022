<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:fourthingsplus>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>
        <form action="tologin" method="post">
            <input type="submit" value="Log in"/>
        </form>


        <h3>You can create a new user here</h3>

        <form action="createuser" method="post">
            <label for="newUsername">Username: </label>
            <input type="text" id="newUsername" name="newUsername"/>
            <label for="newPassword">Password: </label>
            <input type="password" id="newPassword" name="newPassword"/>
            <input type="submit"  value="Create user"/>
        </form>

    </jsp:body>

</t:fourthingsplus>