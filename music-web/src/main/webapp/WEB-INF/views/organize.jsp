<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="public/assets/css/organize.css">
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
// 		$(".table").remove();
		$("#music_table").empty();
		$("#music_table").append('<table class="table table-striped table-condensed table-nonfluid">');
		var requestParam = null;
		var editable = "";
		
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
			var item = "<td><a href=\'javascript:loadMusicDirectoryListing(\""+url+requestParam+"="+elem+"\")'>"+elem+"</a></td>";
			if(requestParam!=null){
				editable = "<td><a href=\'javascript:organizeIt(\""+elem+"\",\""+requestParam.substr(1)+"\")'>edit</a></td>";
			}
			$(".table").append("<tr>"+item+editable+"</tr>");
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
	
	function organizeIt(directory, type){
		console.info(directory);
		console.info(type);
		
		var url = _musicContext+"/app/list/organize?item="+directory+"&type="+type;
		var jqXHR = $.getJSON(url, function(result){
			//dosomething
		}).done(function() {
			console.info("organize call is done");
			populateStash();
		});
			
	}
	
	function populateStash(){
		$("#suggested_changes_area").empty();
		$("#suggested_changes_area").append("<p>This is where the user will be able to view suggested changes and edit or okay them</p>");
	}
	</script>
	
	
	<h3>This is the music organization page</h3>
	<div id="organizational_controls"></div>
	<div id="nav_controls"></div>
	<br><br>
	<div id="music_table"></div>
	<div id="suggested_changes_area"></div>
</body>
</html>
