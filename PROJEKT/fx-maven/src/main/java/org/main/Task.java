package org.main;

public class Task {

        //ID detalu
        private int id;
        //Nazwa detalu/pracy
        private String name;
        //Index detalu np: 12.INVO.1120/15
        private String index;
        //Ile do wykonania
        private int quantity;
        //Ile wykonano
        private int done;
        //Status
        private String status;
        //piorytet
        private String priority;

    public Task(String name, String index, int quantity, int done, String status, String priority) {
        this.name = name;
        this.index = index;
        this.quantity = quantity;
        this.done = done;
        this.status = status;
        this.priority = priority;
    }

    public Task(int id, String name, String index, int quantity, int done, String status, String priority) {
        this.id = id;
        this.name = name;
        this.index = index;
        this.quantity = quantity;
        this.done = done;
        this.status = status;
        this.priority = priority;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", index='" + index + '\'' +
                ", quantity=" + quantity +
                ", done=" + done +
                ", status='" + status + '\'' +
                '}';
    }
}
