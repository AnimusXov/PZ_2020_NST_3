package org.service;

import java.util.List;

import org.entity.UserEntity;

public interface UserService {

    List<UserEntity> getAllUsers();

    void addNewUser(UserEntity user);

    String getUsername();
}
