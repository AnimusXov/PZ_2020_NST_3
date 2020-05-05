package org.entities;

import javax.persistence.*;

@Entity
@Table(name = "departments", schema = "public", catalog = "Firma")
public class DepartmentsEntity {
    private int depId;
    private String name;

    @Id
    @Column(name = "dep_id", nullable = false)
    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
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

        if (depId != that.depId) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = depId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
