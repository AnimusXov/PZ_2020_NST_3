package org.main;

import org.apache.log4j.Logger;
import org.entity.UserEntity;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class testClass {
    final static Logger logger = Logger.getLogger(testClass.class);

    @Autowired
    private UserService userService;
    public void performDbTasks()
    {
        // Get all employees
        List<UserEntity> userList = userService.getAllUsers();
        printEmployees(userList);
        UserEntity empNew = new UserEntity("pracownik2", "haslo3", 1);

        // Save new employee
        userService.addNewUser(empNew);

        // Get all employees - to check added employee
        userList = userService.getAllUsers();
        printEmployees(userList);

        String username = userService.getUsername();
        logger.debug("username: " + username);
    }

    private void printEmployees(List<UserEntity> emplist) {
        if (emplist != null) {
            logger.debug("Znaleziono łącznie " + emplist.size() + " rekordów.");
            for (UserEntity employee : emplist) {
                logger.debug(employee.toString());
            }
        }
    }
}
