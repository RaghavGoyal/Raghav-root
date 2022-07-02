<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Module Test</title>
</head>
<body>

<h2>You are enrolled to: 
<c:if  test="${!empty sessionName}">${sessionName}</c:if>
</h2>
 

 
</body>
</html>