package App;

import Source.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Likes implements Initializable {
    private Post post = App.post;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Like> likeListView;

    @FXML
    protected void appScene(ActionEvent event) throws IOException {
        chaneScene(event, "/Login/login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        likeListView.setItems(FXCollections.observableList(post.getLikes()));
    }

    protected void chaneScene(ActionEvent event, String string) throws IOException {
        root = FXMLLoader.load(getClass().getResource(string + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
