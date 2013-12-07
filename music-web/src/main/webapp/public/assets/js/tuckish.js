
function createPlaylist() {
	var listName = $("#newListName")[0].value;
	$.ajax({
		type: "POST",
		url: "app/playlist/create",
		dataType: "json",
		data: { name: listName },
		success: function(msg) {
			$("#newListName")[0].value = "";
			$("#newPlaylistAlert").html('<p><div class="alert alert-success alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Successfully created playlist</div></p>');
		},
		error: function(msg) {
			$("#newPlaylistAlert").html('<p><div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>Failed to create playlist</div></p>');
		}
	});
}