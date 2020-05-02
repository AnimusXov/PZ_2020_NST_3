package org.dao;


import org.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {
    String getUsername();
}
