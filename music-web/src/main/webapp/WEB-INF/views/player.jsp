<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="public/assets/jPlayerSkins/blue.monday/jplayer.blue.monday.css" rel="stylesheet" />
<link type="text/css" href="public/assets/select2/select2.css" rel="stylesheet" />
<link type="text/css" href="public/assets/css/tuckishplayer.css" rel="stylesheet" />

<script type="text/javascript" src="public/assets/select2/select2.min.js"></script>
<script type="text/javascript" src="public/assets/jPlayer/jQuery.jPlayer.2.4.0/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="public/assets/js/tuckishplayer.js"></script>
<title>Player</title>
</head>
<body>
	<p>
		<input id="plSel" type="hidden" class="populate placeholder select2-offscreen" />
	</p>
	
	<div id="jquery_jplayer_1" class="jp-jplayer"></div>
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
				</div>
				<!-- progress -->
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
				</div>
				<!-- time-holder -->
			</div>

			<!-- jp_gui jp-interface -->
			<div class="jp-title">
				<ul>
					<li>Song Name Here</li>
				</ul>
			</div>
			<div class="jp-no-solution">
				<span>Update Required</span> To play the media you will need to
				either update your browser to a recent version or update your 
				<a href="http://get.adobe.com/flashplayer/" target="_blank">Flash Plugin</a>.
			</div>
		</div>
	</div>
</body>
</html>

