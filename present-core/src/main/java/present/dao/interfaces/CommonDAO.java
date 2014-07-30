package present.dao.interfaces;

/**
 * Parent DAO interface with base methods
 */
public interface CommonDAO<EntityObject> {
    /**
     * Save entity
     * @param entityObject
     */
    void save(EntityObject entityObject);

    /**
     * Delete Entity
     * @param entityObject
     */
    void delete(EntityObject entityObject);

    /**
     * Update entity
     * @param entityObject
     */
    void update(EntityObject entityObject);
}
