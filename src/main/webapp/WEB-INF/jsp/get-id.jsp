<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 27.08.15
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Enter id pupil!</title>
    </head>
    <body>
        <a href="/main">Головна</a>
        <h3>Отримати #</h3>
        <form action="/get-id" method="post">
            <input type="text" name="id">
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
