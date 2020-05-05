package org.dao;

import org.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl extends AbstractGenericDao<UserEntity>  implements UserDao  {

    @Override
    public String getUser(int id) {
        return findById(id).toString();
    }


}
