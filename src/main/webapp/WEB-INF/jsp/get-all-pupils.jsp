<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 27.08.15
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All pupils!</title>
</head>
<body>
    <a href="/main">Головна</a>
    <h3>All pupils</h3>
    <table style="border: 5px double black">
        <thead>
        <tr>
            <td>GROUP</td>
            <td>NAME</td>
            <td>LAST</td>
            <td>LEVE:</td>
            <td>ADDRESS</td>
            <td>ACTIONS</td>
        </tr>
        </thead>
        <tbody style="border: solid black">
        <c:forEach items="${pupilList}" var="tester">
            <tr>
                <td>${tester.group}</td>
                <td>${tester.name}</td>
                <td>${tester.last}</td>
                <td>${tester.level}</td>
                <td>${tester.address}</td>
                <td><a href="/delete/${tester.id}">Delete</a>
                    <a href="/change/${tester.id}">Change</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
