<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"/>
</head>
<body>

<table>
    <tr>
        <th>Code</th>
        <th>Value</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>&lt;%= request.getAttribute("<span class="sel">myparameter</span>")</td>
        <td><%= request.getAttribute("myparameter")%></td>
        <td>JSP Scriptlets</td>
    </tr>
    <tr>
        <td>&#36;{<span class="sel">myparameter</span>}</td>
        <td>${myparameter}</td>
        <td>JSP Expression Language</td>
    </tr>
</table>

</body>
</html>