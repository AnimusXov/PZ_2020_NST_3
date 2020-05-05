package org.dao;


import org.entities.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {
    String getUser(int id);
}
