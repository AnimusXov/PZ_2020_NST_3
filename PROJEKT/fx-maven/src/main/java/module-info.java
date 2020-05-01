module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires spring.data.jpa;
    requires spring.beans;
    requires spring.context;
    requires spring.tx;
    requires log4j;

    opens org.main to javafx.fxml;
    exports org.main;
}