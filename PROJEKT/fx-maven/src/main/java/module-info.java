module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires log4j;
    requires java.naming;
    requires spring.context;
    requires spring.beans;
    requires spring.tx;


    opens org.main to javafx.fxml;
    exports org.main;

}