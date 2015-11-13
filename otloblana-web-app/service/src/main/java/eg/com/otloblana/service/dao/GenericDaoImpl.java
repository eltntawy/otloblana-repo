package eg.com.otloblana.service.dao;


import eg.com.otloblana.common.dao.GenericDao;
import eg.com.otloblana.common.entity.GenericEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mohamed on 2015/07/04.
 */
public class GenericDaoImpl<T extends GenericEntity> implements GenericDao<T> {

    private Class<T> type;
    protected EntityManager entityManager;


    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public T get(Integer id) {
        if (id == null) {
            return null;
        } else {
            return entityManager.find(type, id);
        }
    }

    public List<T> getAll() {
        return entityManager.createQuery("Select entity From " + type.getName() + " entity").getResultList();
    }

    public void save(T object) {
        entityManager.persist(object);
    }

    public void delete(T object) {
        if (!entityManager.contains(object)) {
            object = entityManager.merge(object);
        }
        entityManager.remove(object);
    }

    public void merge(T object) {
        entityManager.merge(object);
    }


}
