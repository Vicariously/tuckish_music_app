<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<script type="text/javascript">
	
	$(document).ready(function(){//document is ready
		loadMusicDirectoryListing(null);
	});
	
	function loadMusicDirectoryListing(url){ 
		var _parentPath, _path, _directory, _fileName, _artist, _album;
		
		if(url == null){
			//default top directory listing of music
			url = _musicContext+"/app/list/select";
		}
		
		var jqXHR = $.getJSON(url, function(result){
			_path = result.path;
			_parentPath = result.parentPath;
			
			if(typeof result.directory !== "undefined"){
				_directory = result.directory;
			}
			if(typeof result.fileName !== "undefined"){
				_fileName = result.fileName;
			}
			if(typeof result.artist !== "undefined"){
				_artist = result.artist;
				//can only check for selected album if an artist has been picked
				if(typeof result.album !== "undefined"){
					_album = result.album;
				}
			}
		}).done(function() {
				populateTable(url, _directory, _artist, _album);
				populateNavigation(_artist, _album, _parentPath);
		}).fail(function() {
				alert("call to server failed");
		});
	}
	
	function populateTable(url, directory, artist, album){
		$(".table").remove();
		$("#music_table").append('<table class="table table-bordered">');
		var requestParam = null;
		
		if(typeof artist === "undefined"){
			var header ="<thead><tr><th>Artists</th></tr></thead>";
			requestParam = "?artist";  //artist always first
		}else if(typeof album === "undefined"){
			var header ="<thead><tr><th>Albums</th></tr></thead>";
			requestParam = "&album";
		}else{
			var header ="<thead><tr><th>Songs</th></tr></thead>";
			requestParam = "&song";
		}
		
		$(".table").append(header);
		
		$.each(directory, function(index, elem){
			var row2 = "<tr><td><a href=\'javascript:loadMusicDirectoryListing(\""+url+requestParam+"="+elem+"\")'>"+elem+"</a></td></tr>";
			$(".table").append(row2);
		});
		
		$("#music_table").append('</table>');
	}
	
	function populateNavigation(artist, album, path){
		$("#nav_controls").empty();
		var url = _musicContext+"/app/list/select";
		var parentHref = "<a href=\'javascript:loadMusicDirectoryListing()\'>"+path+"</a>";
		$("#nav_controls").append(parentHref);

		if(typeof artist !== "undefined"){
			var artistHref = "<a href=\'javascript:loadMusicDirectoryListing(\""+url+"?artist="+artist+"\")\'>"+artist+"</a>";
			$("#nav_controls").append(artistHref+"/");
			
			if(typeof album !== "undefined"){
				var albumHref = "<a href=\'javascript:loadMusicDirectoryListing(\""+url+"?artist="+artist+"&album="+album+"\")\'>"+album+"</a>";
				$("#nav_controls").append(albumHref+"/");
			}
		}
	}
	</script>
	
	
	<h3>This is the music organization page</h3>
	<div id="organizational_controls"></div>
	<div id="nav_controls"></div>
	<br><br>
	<div id="music_table"></div>
</body>
</html>
