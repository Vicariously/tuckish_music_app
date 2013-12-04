<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tuckish Media Player</title>

<link type="text/css" href="public/assets/bootstrap/css/bootstap.min.css" rel="stylesheet" />
<link type="text/css" href="public/assets/jPlayerSkins/blue.monday/jplayer.blue.monday.css" rel="stylesheet" />
<link type="text/css" href="public/assets/css/tuckish.css" rel="stylesheet" />

<script type="text/javascript" src="public/assets/jQuery/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="public/assets/jPlayer/jQuery.jPlayer.2.4.0/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="public/assets/bootstap/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/include/navbar.jsp"/>
	
	<decorator:body />
	
	<c:import url="/WEB-INF/include/footer.jsp"/>
</body>
</html>