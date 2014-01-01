package musiclibrary.impl.common.dao;

import musiclibrary.impl.common.model.Song;
import musiclibrary.impl.common.service.SongService;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongDao extends BaseDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Song> findAll() {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery("select * from song");
		q.addEntity(Song.class);
		List<Song> results = q.list();
		return results;
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

}
