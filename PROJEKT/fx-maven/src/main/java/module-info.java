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
    requires net.bytebuddy;
    requires java.xml.bind;
    requires java.activation;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    exports org.entities;


    opens org.entities to org.hibernate.orm.core;
    opens org.main to javafx.fxml;
    exports org.main;


}