package org.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "departments", schema = "public", catalog = "Firma")
public class DepartmentsEntity {
    private Integer depId;
    private String name;



    private Set<EmployeeEntity> employee;

    @OneToMany(targetEntity = EmployeeEntity.class,mappedBy = "departament")
    public Set<EmployeeEntity> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<EmployeeEntity> employee) {
        this.employee = employee;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentsEntity that = (DepartmentsEntity) o;

        if (depId != null ? !depId.equals(that.depId) : that.depId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }



    @Override
    public int hashCode() {
        int result = depId != null ? depId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
