package org.utils;

import org.entities.EmployeeEntity;
import org.entities.SupplyEntity;
import org.entities.TaskEntity;
import org.hibernateutil.HibernateUtil;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

public class ServiceUtils {

    private  IGenericService<TaskEntity> taskService = new GenericServiceImpl<>(
            TaskEntity.class, HibernateUtil.getSessionFactory());

    private  IGenericService<EmployeeEntity> employeeService = new GenericServiceImpl<>(
            EmployeeEntity.class, HibernateUtil.getSessionFactory());

    private  IGenericService<SupplyEntity>  supplyService = new GenericServiceImpl<>(
            SupplyEntity.class, HibernateUtil.getSessionFactory());


    public IGenericService<SupplyEntity> getSupplyService() {
        return supplyService;
    }

    public void setSupplyService(IGenericService<SupplyEntity> supplyService) {
        this.supplyService = supplyService;
    }

    public IGenericService<TaskEntity> getTaskService() {
        return taskService;
    }

    public void setTaskService(IGenericService<TaskEntity> taskService) {
        this.taskService = taskService;
    }

    public IGenericService<EmployeeEntity> getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(IGenericService<EmployeeEntity> employeeService) {
        this.employeeService = employeeService;
    }
}
