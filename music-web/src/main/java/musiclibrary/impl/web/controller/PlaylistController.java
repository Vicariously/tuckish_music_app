package musiclibrary.impl.web.controller;

import java.util.ArrayList;
import java.util.List;

import musiclibrary.impl.common.entity.Playlist;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/playlist/*")
public class PlaylistController {
	private static final Logger LOG = Logger.getLogger(PlaylistController.class);

	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Playlist> getLists() {
		LOG.trace("Being getLists");

		List<Playlist> playlists = new ArrayList<Playlist>();
		playlists.add(new Playlist(1L, "Meghan's Awesome"));
		playlists.add(new Playlist(2L, "Ryan's Fuzzy"));
		playlists.add(new Playlist(3L, "Workout"));

		return playlists;
	}
}
