package eg.com.otloblana.common.dao;

import eg.com.otloblana.common.entity.GenericEntity;

import java.util.List;


public interface GenericDao<T extends GenericEntity> {

    T get(Integer id);
    List<T> getAll();
    void save(T object);
    void delete(T object);
    void merge(T object);
}
