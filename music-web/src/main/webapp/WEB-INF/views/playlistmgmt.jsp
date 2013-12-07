<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" href="public/assets/select2/select2.css" rel="stylesheet" />

<script type="text/javascript" src="public/assets/select2/select2.min.js"></script>

<title>Playlist Management</title>
</head>
<body>
	<!-- Creating new playlists -->
	<div class="form-group">
		<label for="playlistName">Enter a name to create a playlist</label>
		<input type="text" id="newListName" class="form-control">
		<span class="help-block">Once created, you can add songs to the playlist below.</span>
	</div>
	<button type="button" class="btn btn-default" onclick="createPlaylist();">Create</button>
	<div id="newPlaylistAlert"></div>
	
	<!-- Managing existing playlists -->
	
</body>
</html>
