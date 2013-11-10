<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<%@ page isELIgnored="false" %>
</head>
<body>
<h2>Hello World! This is the Tuckish Productions Music Application View From the Controller Testing Listing Directories of my Music.</h2>
<p> to test the jsp el displaying the content within the model passed from the controller:</p>
<p>${directory}</p>

<c:forEach var="i" items="${directory}">
	<a href="#"><c:out value="${i}"/></a><br>
</c:forEach>
</body>
</html>