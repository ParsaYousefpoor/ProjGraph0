module com.example.projgraph {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projgraph to javafx.fxml;
    exports com.example.projgraph;
}