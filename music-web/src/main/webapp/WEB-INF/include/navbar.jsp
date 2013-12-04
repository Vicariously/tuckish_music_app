<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Tuckish Productions Music</a>
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value="/" />">Home</a></li>
			<li><a href="<c:url value="/player" />">Player</a></li>
			<li><a href="<c:url value="/playlistmgmt" />">Manage Playlists</a></li>
			<li><a href="<c:url value="/organize" />">Organize</a></li>
			<li><a href="<c:url value="/about" />">About</a></li>
		</ul>
	</div>
	</nav>
</body>
</html>