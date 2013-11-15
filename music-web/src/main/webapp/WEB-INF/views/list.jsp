<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html> 
<html>
<head>
<%@ page isELIgnored="false" %>
<link type="text/css" href="http://localhost:8080/music/public/assets/css/tuckish.css" rel="stylesheet" />
<link type="text/css" href="http://localhost:8080/music/public/assets/jPlayerSkins/blue.monday/jplayer.blue.monday.css" rel="stylesheet" />
<script type="text/javascript" src="http://localhost:8080/music/public/assets/jQuery/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/music/public/assets/jPlayer/jQuery.jPlayer.2.4.0/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/music/public/assets/js/tuckishplayer.js"></script>
</head>
<body>
<h2>Tuckish Music Application</h2>

<div class="list">
<h3>All Music</h3>
<%--/genre/artist/album/song --%>
<c:choose>
	<c:when test="${empty artist}">
		<h4>Artist</h4>
		<c:forEach var="i" items="${directory}">
			<a href="http://localhost:8080/music/app/list/select?artist=${i}"><c:out value="${i}"/></a><br>
		</c:forEach>
	</c:when>
	<c:when test="${empty album}">
		<h4>Album</h4>
		<c:forEach var="i" items="${directory}">
			<a href="http://localhost:8080/music/app/list/select?artist=${artist}&album=${i}"><c:out value="${i}"/></a><br>
		</c:forEach>
	</c:when>
	<c:when test="${not empty album}">
		<h4>Song</h4>
		 <c:forEach var="i" items="${directory}">
			Play: &nbsp;<a href="http://localhost:8080/music/app/stream/play?artist=${artist}&album=${album}&song=${i}"><c:out value="${i}"/></a><br>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>Cannot find path or directory</p>
	</c:otherwise>
</c:choose>
</div>

<div class="player"><div id="jquery_jplayer_1" class="jp-jplayer"></div>
	<div id="jp_container_1" class="jp-audio">
		<div class="jp-type-single">
			<div class="jp_gui jp-interface">
				<ul class="jp-controls">
						<li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
                        <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
                        <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
                        <li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
                        <li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
                        <li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
				</ul>
				<div class="jp-progress">
					<div class="jp-seek-bar">
						<div class="jp-play-bar"></div>
					</div>
				</div><!-- progress -->
				<div class="jp-volume-bar">
          			<div class="jp-volume-bar-value"></div>
        		</div>
        		<div class="jp-time-holder">
          			<div class="jp-current-time"></div>
        			<div class="jp-duration"></div>
          			<ul class="jp-toggles">
            			<li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
            			<li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
          			</ul>
        		</div><!-- time-holder -->
            </div><!-- jp_gui jp-interface -->
            <div class="jp-title">
		        <ul>
		          <li>Enter Song Name Here</li>
		        </ul>
     		 </div>
     		 <div class="jp-no-solution">
        		<span>Update Required</span>
        		To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
     		 </div>
	    </div>
	</div>
</div>
<div class="playlist"><h3>Playlist</h3></div>

</body>
</html>