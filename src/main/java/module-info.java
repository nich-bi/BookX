module org.project.logic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.project.logic to javafx.fxml;
    exports org.project.logic;
    exports org.project.logic.view;
    opens org.project.logic.view to javafx.fxml;
}