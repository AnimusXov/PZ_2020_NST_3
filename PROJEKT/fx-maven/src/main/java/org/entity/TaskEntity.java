package org.entity;

import javax.persistence.*;

@Entity
@Table(name = "task", schema = "public", catalog = "Firma")
public class TaskEntity {
    private String status;
    private int taskId;
    private Short quantity;
    private Short done;
    private String name;
    private String index;
    private String piority;

    @Basic
    @Column(name = "status", nullable = true, length = 12)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Id
    @Column(name = "task_id", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "done", nullable = true)
    public Short getDone() {
        return done;
    }

    public void setDone(Short done) {
        this.done = done;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "index", nullable = false, length = -1)
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Basic
    @Column(name = "piority", nullable = true, length = -1)
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

        TaskEntity that = (TaskEntity) o;

        if (taskId != that.taskId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
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
        result = 31 * result + taskId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (piority != null ? piority.hashCode() : 0);
        return result;
    }
}
