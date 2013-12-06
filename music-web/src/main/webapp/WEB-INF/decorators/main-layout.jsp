<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tuckish Media <sitemesh:write property='title'/></title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="public/assets/jPlayerSkins/blue.monday/jplayer.blue.monday.css" />
<link rel="stylesheet" href="public/assets/css/tuckish.css" />

<sitemesh:write property='head'/>
</head>
<body>
	<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script src="public/assets/jPlayer/jQuery.jPlayer.2.4.0/jquery.jplayer.min.js"></script>
	<script src="public/assets/js/tuckishplayer.js"></script>
	
	<c:import url="/WEB-INF/include/navbar.jsp"/>
	
	<sitemesh:write property='body'/>
	
	<div class="navbar navbar-fixed-bottom">
		<c:import url="/WEB-INF/include/footer.jsp"/>
	</div>
</body>
</html>