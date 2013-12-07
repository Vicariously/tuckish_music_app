package musiclibrary.impl.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musiclibrary.impl.common.entity.NamedEntity;
import musiclibrary.impl.common.entity.Playlist;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/playlist/*")
public class PlaylistController {
	private static final Logger LOG = Logger.getLogger(PlaylistController.class);

	/**
	 * Retrieves any {@link Playlist} objects from the database and send them
	 * back to the client marshalled as JSON
	 * 
	 * @return {@link List} of {@link Playlist} objects as a JSON string
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

	/**
	 * Persists a new {@link Playlist} object in the database. The
	 * {@link Playlist} does not start with any associated {@link Song}
	 * 
	 * @param playlist
	 *            the object holding the form inputs, mainly the 'name'
	 *            parameter
	 * @param request
	 *            the {@link HttpServletRequest}
	 * @param response
	 *            the {@link HttpServletResponse}
	 * @return the {@link Playlist} object created in the database
	 * @throws IOException
	 *             when an error occurs sending an error response to the client
	 */
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Playlist createPlaylist(@ModelAttribute(value = "name") NamedEntity playlist, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		LOG.trace("Begin createPlaylist");

		if (playlist == null || StringUtils.isBlank(playlist.getName())) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid playlist name");
			return null;
		}

		LOG.info("Received create request for " + playlist.getName());
		Playlist persisted = new Playlist(1l, playlist.getName());

		return persisted;
	}
}
