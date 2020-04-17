module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jfxtras.styles.jmetro;


    opens org.example to javafx.fxml;
    exports org.example;
}