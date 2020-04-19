module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;
    requires org.hibernate.orm.core;
    requires java.persistence;


    opens org.main to javafx.fxml;
    exports org.main;
}