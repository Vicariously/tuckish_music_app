// instance jplayer here
// use ajax to get a new mp3 and set the new mp3 in this jplayers instance

$(document).ready(function() {
	// Select2 form fields
	$("#plSel").select2({
		width: "300",
		placeholder: "Select a playlist",
		allowClear: true,
		ajax: {
			url: "app/playlist/all",
			dataType: "json",
			results: function (data) {
				var results = [];
				$.each(data, function(index, item) {
					results.push({
						id: item.id,
						text: item.name
					});
				});
				
				return {
					results: results
				};
	        }
		}
	});
	$("#plSel").on("change", function(e) {
		if (e.added !== undefined) {
			alert("Changing playlist to: " + e.added.text);
		}
	});
	
	// jPlayer with playlist
	var ffaction;
	var rwaction;
	var rewinding = false;
	var fastforwarding = false;
	var paused = false;
	
    var myPlaylist = new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
	},[{
		 title:"Jolene",
		 artist:"The White Stripes",
		 mp3:"app/play"
	}],{
		playlistOptions: {
			enableRemoveControls: true
		},
		swfPath: "public/assets/jPlayer",
		supplied: "mp3",
		wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true
    });
	
	$(document).delegate('*', 'keydown',  function (e) {
		//Rewind
		if(e.keyCode == 37 && (!rewinding)) { //left arrow key pressed
			rewinding = true;
			$("#jquery_jplayer_1").jPlayer("pause");
			rewind();
			rwaction = window.setInterval(function(){rewind();}, 500);
		} else if (e.keyCode == 39 && (!fastforwarding)) { //right arrow key pressed
			fastforwarding = true;
			$("#jquery_jplayer_1").jPlayer("pause");
			fastforward();
			ffaction = window.setInterval(function(){fastforward();}, 500);
		}
	});
	
	$(document).delegate('*', 'keyup',  function (e) {
		//stop Rewind
		if (e.keyCode == 37) { //left arrow key up
			rewinding = false;
			window.clearInterval(rwaction);
			$("#jquery_jplayer_1").jPlayer("pause");
		} else if (e.keyCode == 39) {//right arrow key up
			//stop ff
			fastforwarding = false;
			window.clearInterval(ffaction);
			$("#jquery_jplayer_1").jPlayer("pause");
		}
	});
	
	function getPlayerProgress() {
		var toReturn = ($('.jp-play-bar').width() / $('.jp-seek-bar').width()) * 100;
		return (toReturn);
		//width() sets or returns width of selected element; not including padding, border, margin
	}
	
	function rewind() {
		var progress = getPlayerProgress();
		var futureprogress = progress - 10;
		if (futureprogress<=10) {
			rewinding = false;
			window.clearInterval(rwaction);
			$("#jquery_jplayer_1").jPlayer("pause", 0);
		} else {
			$("#jquery_jplayer_1").jPlayer("playHead", futureprogress);
		}
	}
	
	function fastforward() {
		var progress = getPlayerProgress();
		var futureprogress = progress + 10;
		if (futureprogress >= 100) {
			fastforwarding = false;
			window.clearIntervale(ffaction);
			$("#jquery_jplayer_1").jPlayer("pause", 0);
		} else {
			$("#jquery_jplayer_1").jPlayer("playHead", futureprogress);
		}
	}
});
