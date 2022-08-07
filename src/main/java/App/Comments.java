package App;

import Source.Post;
import Source.Replay;
import Source.Search;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Comments implements Initializable {
    private Post post = App.post;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Replay> commentsList;
    private ArrayList<Replay> selectedReply;

    @FXML
    protected void appScene(ActionEvent event) throws IOException {
        chaneScene(event, "/Login/login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        commentsList.setItems(FXCollections.observableList(Search.getReplay(post)));
//        postsList.setItems(FXCollections.observableList(user.getPosts()));
    }

    protected void chaneScene(ActionEvent event, String string) throws IOException {
        root = FXMLLoader.load(getClass().getResource(string + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
