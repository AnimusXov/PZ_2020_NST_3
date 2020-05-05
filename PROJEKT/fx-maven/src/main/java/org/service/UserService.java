package org.service;

import java.util.List;

import org.entities.UserEntity;

public interface UserService {

    List<UserEntity> getAllUsers();

    void addNewUser(UserEntity user);

    String getUsername();
}
