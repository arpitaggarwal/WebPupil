<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 27.08.15
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change pupil!</title>
</head>
    <body>
        <a href="/main">Головна</a>
        <h3>Pupil for change:</h3>
        <table>
            <thead>
            <tr>
                <td>ID</td>
                <td>NAME</td>
                <td>LAST</td>
                <td>LEVEL</td>
                <td>ADDRESS</td>
                <td>GROUP</td>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${pupil.id}</td>
                    <td>${pupil.name}</td>
                    <td>${pupil.last}</td>
                    <td>${pupil.level}</td>
                    <td>${pupil.address}</td>
                    <td>${pupil.group}</td>
                </tr>
            </tbody>
        </table>
        <h3>Enter new value for change:</h3>
        <form method="get" action="/change-pupil/${pupil.id}">
            ID:   <input type="text" name="id" value="${pupil.id}" disabled>
            Name: <input type="text" name="name" value="${pupil.name}">
            Last: <input type="text" name="last" value="${pupil.last}">
            Level: <input type="text" name="level" value="${pupil.level}">
            Address: <input type="text" name="address" value="${pupil.address}">
            Group: <input type="text" name="group" value="${pupil.group}">
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
