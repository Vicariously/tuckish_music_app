package musiclibrary.impl.common.service;

import java.util.List;

import musiclibrary.impl.common.dao.SongDao;
import musiclibrary.impl.common.model.Song;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class SongService {
	private static final Logger logger = Logger.getLogger(SongService.class);

	@Autowired
	private SongDao songDao;

	public List<Song> getSongs() {
		List<Song> songs = songDao.findAll();
		logger.info("Found " + songs.size() + " total songs");

		return songs;
	}
}
