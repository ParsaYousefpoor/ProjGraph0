package App;

import Source.User;
import com.example.projgraph.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Groups implements Initializable {
    private User user = HelloApplication.user;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label nameLabel;
    @FXML
    private Label userLabel;
    @FXML
    private Label followerLabel;
    @FXML
    private Label followingLabel;

    @FXML
    protected void logout(ActionEvent event) throws IOException {
        user.saveLogout();
        root = FXMLLoader.load(getClass().getResource("/Login/login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(user.getName());
        userLabel.setText(user.getUsername());
        followerLabel.setText(Integer.toString(user.getFollowers().size()));
        followingLabel.setText(Integer.toString(user.getFollowings().size()));
    }
}
