package org.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments", schema = "public", catalog = "Firma")
public class DepartmentsEntity {
    private Integer depId;
    private String dep_name;




    private Set<TaskEntity> task;


    private Set<EmployeeEntity> employee;




    @OneToMany(targetEntity = TaskEntity.class,mappedBy = "depa2",cascade = CascadeType.MERGE)
    public Set<TaskEntity> getTask() {
        return task;
    }

    @OneToMany(targetEntity = EmployeeEntity.class,mappedBy = "departament",cascade = CascadeType.ALL)
    public Set<EmployeeEntity> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<EmployeeEntity> employee) {
        this.employee = employee;
    }

    public void setTask(Set<TaskEntity> task) {
        this.task = task;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id", nullable = false)
    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String name) {
        this.dep_name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentsEntity that = (DepartmentsEntity) o;

        if (depId != null ? !depId.equals(that.depId) : that.depId != null) return false;
        if (dep_name != null ? !dep_name.equals(that.dep_name) : that.dep_name != null) return false;

        return true;
    }



    @Override
    public int hashCode() {
        int result = depId != null ? depId.hashCode() : 0;
        result = 31 * result + (dep_name != null ? dep_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return dep_name;
    }
}
