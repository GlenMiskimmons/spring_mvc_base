<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Goals Report</title>
    <meta name="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <table>
        <tr>
            <th id="Minutes">Minutes</th>
            <th id="exerciseMinutes">Exercise Minutes</th>
            <th id="exerciseActivity">Activity</th>
        </tr>
        <c:forEach items="${goalReports}" var="goalReport">
            <tr>
                <td>${goalReport.goalMinutes}</td>
                <td>${goalReport.exerciseMinutes}</td>
                <td>${goalReport.exerciseActivity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
