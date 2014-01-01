package musiclibrary.impl.common.dao;

import org.hibernate.SessionFactory;
import java.util.List;

public abstract class BaseDao {
	
	
	public abstract List<?> findAll();
	
	public abstract void remove(Object obj);
	
	public abstract Object findById(long id);
	
	public abstract Object save(Object obj);
	
	public abstract void flush();
	
	public abstract SessionFactory getSessionFactory();

}
