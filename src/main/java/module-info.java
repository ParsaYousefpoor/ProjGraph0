module com.example.projgraph {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projgraph to javafx.fxml;
    exports com.example.projgraph;
    exports Login;
    opens Login to javafx.fxml;
    exports App;
    opens App to javafx.fxml;
}