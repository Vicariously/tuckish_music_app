package musiclibrary.impl.common.service;

import musiclibrary.impl.common.dao.SongDao;
import musiclibrary.impl.common.model.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
@Service
public class SongService {
	
	@Autowired
	SongDao songDao;
	
	public List<Song> getSongs(){
		return this.songDao.findAll();
	}
}
