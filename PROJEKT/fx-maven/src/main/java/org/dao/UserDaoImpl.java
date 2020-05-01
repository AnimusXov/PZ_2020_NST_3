package org.dao;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import org.entity.EmployeeEntity;

@Repository
public class UserDaoImpl extends AbstractGenericDao<EmployeeEntity> implements UserDao {

    @Override
    public String getUsername() {
        Criteria criteria = getSession().createCriteria(EmployeeEntity.class).setProjection(Projections.property("username"));
        return (String) criteria.uniqueResult();
    }

}
