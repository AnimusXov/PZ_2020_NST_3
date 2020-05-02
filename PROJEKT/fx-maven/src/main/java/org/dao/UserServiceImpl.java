package org.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.entity.UserEntity;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.entity.UserEntity;
import org.dao.UserDao;

public class UserServiceImpl implements UserService {

    final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    public List<UserEntity> getAllUsers() {
        logger.debug("Pobieranie wszystkich użytkowników...");
        return userDao.findAll();
    }

    /**
     * Add new employee if it in not already exists
     *
     * @param user: User to add
     */
    @Override
    @Transactional(readOnly = false)
    public void addNewUser(UserEntity user) {
        UserEntity emp = new UserEntity();
        emp.setUsername(user.getUsername());
        emp.setPassword(user.getPassword());
        emp.setAccessLevel(user.getAccessLevel());
        List<UserEntity> emplList = userDao.findAllByExample(emp);
        if (emplList == null || emplList.isEmpty()) {
            Long id = (Long) userDao.save(user);
            logger.debug("Id nowego użytkownika " + id);
        } else {
            logger.debug("Użytkownik " + emp + " already exists");
        }
    }

    /**
     * Return maximum salary given to any user
     *
     * @return max salary
     */
    @Override
    public String getUsername() {
        return  userDao.getUsername();
    }

}