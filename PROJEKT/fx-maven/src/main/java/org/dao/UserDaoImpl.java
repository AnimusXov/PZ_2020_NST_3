package org.dao;


import org.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import org.entity.EmployeeEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserDaoImpl extends AbstractGenericDao<UserEntity> implements UserDao {

    @Override
    public String getUsername() {

        return "test";
    }

}
