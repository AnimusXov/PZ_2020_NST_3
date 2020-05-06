package org.service;


import org.dao.IDao;

import java.util.List;

public interface IGenericService<T> extends IDao<T> {
        List<T> getAll();
        void deleteAll();
    }
