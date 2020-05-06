package org.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDao<T> {

    public T get(Class<T> cl, Integer id);
    public T save(T object);
    public void update(T object);
    public void delete(T object);
    public List<T> query(String hsql, Map<String, Object> params);
}
