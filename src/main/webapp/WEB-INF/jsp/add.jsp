<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 26.08.15
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add pupil!</title>
</head>
    <body>
        <a href="/main">Головна</a>

        <h3>This is add.jsp</h3>

        <form action="/add-pupil" method="POST">
            <input name="name" type="text" placeholder="Name">
            <input name="last" type="text" placeholder="Last">
            <input name="level" type="text" placeholder="Level">
            <input name="group" type="text" placeholder="Group">
            <input name="address" type="text" placeholder="Address">
            <input name="Submit" type="submit">
        </form>
    </body>
</html>
