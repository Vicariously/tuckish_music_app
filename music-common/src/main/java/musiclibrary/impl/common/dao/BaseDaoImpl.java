package musiclibrary.impl.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import musiclibrary.impl.common.entity.BaseEntity;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDaoImpl implements BaseDao {
	private static final Logger LOG = Logger.getLogger(BaseDaoImpl.class);

	@PersistenceContext
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see musiclibrary.impl.common.dao.BaseDao#findAll(java.lang.Class)
	 */
	@Override
	public <T extends BaseEntity> List<T> findAll(Class<T> clazz) {
		LOG.debug("Performing query generic.findAll for " + clazz.getName());

		TypedQuery<T> query = em.createQuery("SELECT e FROM " + clazz.getName() + " e", clazz);
		List<T> entities = query.getResultList();

		return entities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see musiclibrary.impl.common.dao.BaseDao#find(java.lang.Class, long)
	 */
	@Override
	public <T extends BaseEntity> T find(Class<T> clazz, long id) {
		LOG.debug("Performing query generic.find for " + clazz.getName());

		T entity = em.find(clazz, id);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * musiclibrary.impl.common.dao.BaseDao#save(musiclibrary.impl.common.entity
	 * .BaseEntity)
	 */
	@Override
	public <T extends BaseEntity> T save(T entity) {
		LOG.debug("Performing generic.save for " + entity.getClass().getName());

		if (entity.getId() == 0) {
			em.persist(entity);
		}

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see musiclibrary.impl.common.dao.BaseDao#update(java.lang.Class,
	 * musiclibrary.impl.common.entity.BaseEntity)
	 */
	@Override
	public <T extends BaseEntity> T update(Class<T> clazz, T entity) {
		LOG.debug("Performing generic.update for " + clazz.getName() + ", id = " + entity.getId());

		T persisted = em.find(clazz, entity.getId());
		if (persisted != null) {
			em.merge(entity);
		}

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see musiclibrary.impl.common.dao.BaseDao#delete(java.lang.Class, long)
	 */
	@Override
	public <T extends BaseEntity> void delete(Class<T> clazz, long id) {
		LOG.debug("Performing generic.delete for " + clazz.getName() + ", id = " + id);

		T persisted = em.find(clazz, id);
		if (persisted != null) {
			em.remove(persisted);
		}
	}
}
