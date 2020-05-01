package org.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.main.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.entity.UserEntity;
import org.dao.UserDao;

public class UserServiceImpl implements UserService {

    final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao employeeDao;

    public List<User> getAllEmployees() {
        logger.debug("Getting all employees...");
        return UserDao.findAll();
    }

    /**
     * Add new employee if it in not already exists
     *
     * @param employee: Employee to add
     */
    @Override
    @Transactional(readOnly = false)
    public void addNewEmployee(User user) {
        User emp = new User();
        emp.setFirstname(employee.getFirstname());
        emp.setLastname(employee.getLastname());
        List<Employee> emplList = employeeDao.findAllByExample(emp);
        if (emplList == null || emplList.isEmpty()) {
            Long id = (Long) employeeDao.save(employee);
            logger.debug("Id of new Employee " + id);
        } else {
            logger.debug("Employee " + emp + " already exists");
        }
    }

    /**
     * Return maximum salary given to any employee
     *
     * @return max salary
     */
    @Override
    public Integer getMaxSalary() {
        return employeeDao.getMaxSalary();
    }

}