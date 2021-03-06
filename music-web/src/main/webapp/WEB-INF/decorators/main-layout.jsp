<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tuckish Media <sitemesh:write property='title'/></title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link type="text/css" href="public/assets/css/tuckish.css" rel="stylesheet" />

<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="public/assets/js/tuckish.js"></script>

<sitemesh:write property='head'/>
</head>
<body>
	<c:import url="/WEB-INF/include/navbar.jsp" />

	<sitemesh:write property='body'/>

	<div class="navbar navbar-fixed-bottom">
		<c:import url="/WEB-INF/include/footer.jsp" />
	</div>
</body>
</html>