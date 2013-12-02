package musiclibrary.impl.common.dao;

import java.util.List;

import musiclibrary.impl.common.entity.BaseEntity;

public interface BaseDao {
	/**
	 * Returns all persisted database records for the corresponding class type.
	 * 
	 * @param clazz
	 *            the class type of the entity, which must extend
	 *            {@link BaseEntity}
	 * @return {@link List} of persisted entities
	 */
	<T extends BaseEntity> List<T> findAll(Class<T> clazz);

	/**
	 * Returns a specific persisted database record for the corresponding class
	 * type and id.
	 * 
	 * @param clazz
	 *            the class type of the entity, which must extend
	 *            {@link BaseEntity}
	 * @param id
	 *            the id value of the persisted record
	 * @return a single entity object
	 */
	<T extends BaseEntity> T find(Class<T> clazz, long id);

	/**
	 * Persists the provided entity to the database.
	 * 
	 * @param entity
	 *            the new entity to persist, which must extend
	 *            {@link BaseEntity}
	 * @return the persisted copy of the entity
	 */
	<T extends BaseEntity> T save(T entity);

	/**
	 * Updates a specific persisted database record matching the corresponding
	 * class.
	 * 
	 * @param clazz
	 *            the class type of the entity, which must extend
	 *            {@link BaseEntity}
	 * @param entity
	 *            the new version of the entity that should be persisted
	 * @return the updated version of the entity
	 */
	<T extends BaseEntity> T update(Class<T> clazz, T entity);

	/**
	 * Deletes a persisted entity from the database.
	 * 
	 * @param clazz
	 *            the class type of the entity, which must extend
	 *            {@link BaseEntity}
	 * @param id
	 *            the id value of the persisted record
	 */
	<T extends BaseEntity> void delete(Class<T> clazz, long id);
}
