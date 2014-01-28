package musiclibrary.impl.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import musiclibrary.impl.common.model.Album;
import musiclibrary.impl.common.model.Artist;
import musiclibrary.impl.common.model.Genre;
import musiclibrary.impl.common.model.Song;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:testcontexts/music-common-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SongServiceTest {
	private final static Logger logger = Logger.getLogger(SongServiceTest.class);

	@Autowired
	private SongService songService;

	@Test
	public void testGetSongs() {
		logger.info("Starting SongServer.getSongs Test");

		List<Song> songs = songService.getSongs();
		assertNotNull(songs);
		assertEquals(1, songs.size());

		// Test relations
		logger.info("Testing Song relations");
		Song song = songs.get(0);

		// Artist
		logger.info("Testing Song.Artist relation");
		Artist artist = song.getArtist();
		assertNotNull(artist);
		assertEquals("Everlast", artist.getName());

		// Genre
		logger.info("Testing Artist.Genre relation");
		Genre genre = artist.getGenre();
		assertNotNull(genre);
		assertEquals("Blues Rock", genre.getName());

		// Album
		logger.info("Testing Song.Album relation");
		Album album = song.getAlbum();
		assertNotNull(album);
		assertEquals("Whitey Ford Sings the Blues", album.getTitle());

		logger.info("Completed SongServer.getSongs Test");
	}
}
