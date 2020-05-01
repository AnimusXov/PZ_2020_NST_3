package org.dao;

import org.entity.EmployeeEntity;

public interface UserDao extends GenericDao<EmployeeEntity> {
    String getUsername();
}
