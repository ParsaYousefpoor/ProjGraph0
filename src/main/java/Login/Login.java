package Login;

import Source.*;

import com.example.projgraph.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label label;
//    @FXML
//    public void login(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Login");
//        stage.show();
//    }

    @FXML
    protected void login(ActionEvent event) throws IOException {
        String s1 = username.getText();
        String s2 = password.getText();
        if (s1 != null && s2 != null) {
            if (Search.existUser(s1)) {
                User user = Search.whichUser(s1);
                if (s2.equals(user.getPassword())) {
                    HelloApplication.user = user;
//                    root = FXMLLoader.load(getClass().getResource("forgot.fxml"));
//                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                    scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                } else if (s2.length() < 8) {
                    label.setText("Password is at least 8 characters");
                } else {
                    label.setText("Wrong password");
                }
            } else {
                label.setText("No user exist with this username");
            }
        } else {
            if (s1 != null) {
                label.setText("Enter password");
            } else if (s2 != null) {
                label.setText("Enter username");
            } else {
                label.setText("Enter username and password");
            }
        }
    }

    @FXML
    protected void forgot(ActionEvent event) throws IOException {
        String s1 = username.getText();
        if (s1 != null) {
            if (Search.existUser(s1)) {
                User user = Search.whichUser(s1);
                changeScene(event, "forgot");
            } else {
                label.setText("No user exist with this username");
            }
        } else {
            label.setText("Enter a username before recovering password");
        }
    }

    @FXML
    protected void signup(ActionEvent event) throws IOException {
        changeScene(event, "signup");
    }

    protected void changeScene(ActionEvent event, String string) throws IOException {
        root = FXMLLoader.load(getClass().getResource(string + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
