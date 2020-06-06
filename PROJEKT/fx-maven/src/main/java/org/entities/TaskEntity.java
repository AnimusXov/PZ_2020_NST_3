package org.entities;

import javax.persistence.*;

@Entity
@Table(name = "task", schema = "public", catalog = "Firma")
public class TaskEntity {
    @Basic
    @Column(name = "status", nullable = true)
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id", nullable = false)
    private Integer taskId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Short quantity;
    @Basic
    @Column(name = "done", nullable = true)
    private Short done;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "index", nullable = false, length = -1)
    private String index;
    @Basic
    @Column(name = "piority", nullable = true, length = -1)
    private String piority;

    @ManyToOne
    @JoinColumn(name="dep_id")
    private  DepartmentsEntity depa2;


    public DepartmentsEntity getDepartament() {
        return depa2;
    }

    public void setDepartament(DepartmentsEntity departament) {
        this.depa2 = departament;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }


    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }


    public Short getDone() {
        return done;
    }

    public void setDone(Short done) {
        this.done = done;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }


    public String getPiority() {
        return piority;
    }

    public void setPiority(String piority) {
        this.piority = piority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        org.entities.TaskEntity that = (org.entities.TaskEntity) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (done != null ? !done.equals(that.done) : that.done != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (piority != null ? !piority.equals(that.piority) : that.piority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (piority != null ? piority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
               "Nazwa: " + name  + "\n" +
               "Index: " + index + "\n" +
               "Ilość: " + quantity + "\n"+
               "Ile Zr.: "  + done  + "\n" +
               "Status: "   + status+ "\n" +
               "Piorytet: " + piority+ "\n" ;




    }
}

