package App;

import Source.Post;
import Source.Replay;
import Source.Search;
import Source.User;
import com.example.projgraph.HelloApplication;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Comments implements Initializable {
    private User user = HelloApplication.user;
    private Post post = App.post;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Replay> commentsList;
    private ArrayList<Replay> replays;
    private ArrayList<Replay> selectedReply;

    @FXML
    protected void appScene(ActionEvent event) throws IOException {
        chaneScene(event, "/Login/login");
    }

    @FXML
    protected void show() {
        Replay r = commentsList.getSelectionModel().getSelectedItem();
        if (r != null) {
            if (!selectedReply.contains(r)) {
                replays = Search.addReplay(replays, r);
                selectedReply.add(r);
            } else {
                replays = Search.removeReplay(replays, r);
                selectedReply.remove(r);
            }
            commentsList.setItems(FXCollections.observableList(replays));
        }
    }

    @FXML
    protected void like() {
        Replay r = commentsList.getSelectionModel().getSelectedItem();
        if (r != null) {
            r.addLike(user);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedReply = new ArrayList<>();
        replays = Search.getReplay(post);
        commentsList.setItems(FXCollections.observableList(replays));
    }

    protected void chaneScene(ActionEvent event, String string) throws IOException {
        root = FXMLLoader.load(getClass().getResource(string + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
