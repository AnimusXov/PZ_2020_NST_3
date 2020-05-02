/**
 *
 */
module org.example {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;
    requires log4j;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires java.persistence;


    opens org.main to javafx.fxml;
    exports org.main;


}