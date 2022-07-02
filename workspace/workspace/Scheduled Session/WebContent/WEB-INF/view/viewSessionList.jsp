<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Module Test</title>
</head>
<body>

<h2>Scheduled Sessions</h2>
 
<c:if  test="${!empty sessionList}">
<table class="data">
<tr>
    <th>SessionName</th>
    <th>Duration (Days)</th>
    <th>Faculty</th>
    <th>Mode</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${sessionList}" var="ses">
    <tr>
        <td>${ses.name} </td>
        <td>${ses.duration}</td>
        <td>${ses.faculty}</td>
        <td>${ses.model}</td>
        <td><a href="success/${ses.id}">Enroll Me</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>