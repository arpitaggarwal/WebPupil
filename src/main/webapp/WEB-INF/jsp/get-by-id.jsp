<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 27.08.15
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Учень № ${model.id}</title>
</head>
    <body>
         <a href="/main">Головна</a>
         <c:if test="${not empty model}">
            <table>
                <thead>
                    <tr>
                        <td>NAME</td>
                        <td>LAST</td>
                        <td>GROUP</td>
                        <td>LEVEL</td>
                        <td>ADDRESS</td>
                        <td>ACTIONS</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${model.name}</td>
                        <td>${model.last}</td>
                        <td>${model.group}</td>
                        <td>${model.level}</td>
                        <td>${model.address}</td>
                        <td><a href="/delete/${model.id}">Delete</a>
                            <a href="/change/${model.id}">Change</a>
                        </td>
                    </tr>
                </tbody>
            </table>
         </c:if>
        <c:if test="${empty model}">
            <h3 style="color: brown">Pupil not found!</h3>
        </c:if>
    </body>
</html>
