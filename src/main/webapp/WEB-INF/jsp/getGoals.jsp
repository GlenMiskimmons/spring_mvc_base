<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Goals</title>
    <meta name="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <table>
        <tr>
            <th id="id">Id</th>
            <th id="Minutes">Minutes</th>
        </tr>
        <c:forEach items="${goals}" var="goal">
            <tr>
                <td>${goal.id}</td>
                <td>${goal.minutes}</td>
                <td>
                     <table>
                         <tr>
                            <th id="exerciseId">Exercise Id</th>
                            <th id="exerciseMinutes">Exercise Minutes</th>
                            <th id="exerciseActivity">Exercise Activity</th>
                         </tr>
                         <c:forEach items="${goal.exercises}" var="exercise">
                             <tr>
                                 <td>${exercise.id}</td>
                                 <td>${exercise.minutes}</td>
                                 <td>${exercise.activity}</td>
                             </tr>
                         </c:forEach>
                     </table>
                 </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
