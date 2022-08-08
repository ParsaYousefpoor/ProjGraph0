package App;

import Source.*;

import com.example.projgraph.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class App implements Initializable {
    public static Post post;
    private User user = HelloApplication.user;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label accountType;
    @FXML
    private Label nameLabel;
    @FXML
    private Label userLabel;
    @FXML
    private Label followerLabel;
    @FXML
    private Label followingLabel;
    @FXML
    private Label warning;
    @FXML
    private Button details;
    @FXML
    private TextField postText;
    @FXML
    private ListView<Post> postsList;

    @FXML
    protected void logout(ActionEvent event) throws IOException {
        user.saveLogout();
        chaneScene(event, "/Login/login");
    }

    @FXML
    protected void groupShow(ActionEvent event) throws IOException {
        chaneScene(event, "groups");
    }

    @FXML
    protected void chatShow(ActionEvent event) throws IOException {
        chaneScene(event, "chats");
    }

    @FXML
    protected void likeShow(ActionEvent event) throws IOException {
        post = postsList.getSelectionModel().getSelectedItem();
        if (post != null) {
            chaneScene(event, "likes");
        }
    }

    @FXML
    protected void commentShow(ActionEvent event) throws IOException {
        post = postsList.getSelectionModel().getSelectedItem();
        if (post != null) {
            chaneScene(event, "comments");
        }
    }

    @FXML
    protected void detailShow(ActionEvent event) throws IOException {
        post = postsList.getSelectionModel().getSelectedItem();
        if (post != null) {
            chaneScene(event, "details");
        }
    }

    @FXML
    protected void addNewPost() {
        String temp = postText.getText();
        if (temp != null && temp.length() != 0) {
            Post post1;
            if (user instanceof UserBusiness) {
                PostBusiness post = new PostBusiness(user, temp);
                post1 = post;
            } else {
                PostNormal post = new PostNormal(user, temp);
                post1 = post;
            }
            user.newPost(post1);
            postsList.setItems(FXCollections.observableList(Search.getPost(user)));
            postText.setText("");
            warning.setVisible(false);
        } else {
            warning.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (user instanceof UserNormal) {
            accountType.setText("Normal account");
            details.setVisible(false);
        } else {
            accountType.setText("Business account");
            details.setVisible(true);
        }
        nameLabel.setText(user.getName());
        userLabel.setText(user.getUsername());
        followerLabel.setText(Integer.toString(user.getFollowers().size()));
        followingLabel.setText(Integer.toString(user.getFollowings().size()));
        postsList.setItems(FXCollections.observableList(Search.getPost(user)));
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
