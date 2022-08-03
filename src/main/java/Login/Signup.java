package Login;

import Source.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Signup {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField name;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField recovery;
    @FXML
    private Label label;
    @FXML
    private ToggleGroup tg;
    @FXML
    private RadioButton normal;
    @FXML
    private RadioButton business;

    @FXML
    protected void create(ActionEvent event) throws IOException {
        String s1 = name.getText();
        String s2 = username.getText();
        String s3 = password.getText();
        String s4 = recovery.getText();
        if (s1 == null) {
            label.setText("Enter a name for your account");
        } else if (s2 == null) {
            label.setText("Enter a username for your account");
        } else if (s3 == null) {
            label.setText("Enter a password for your account");
        } else if (s4 == null) {
            label.setText("Enter an answer for your recovering your password");
        } else {
            if (Search.existUser(s2)) {
                label.setText("A user with this username already exist");
            } else if (s3.length() < 8) {
                label.setText("Password must have at least 8 characters");
            } else {
                if (normal.isSelected()) {
                    UserNormal user = new UserNormal(s1, s2, s3);
                    user.setPassrecov(s4);
                } else {
                    UserBusiness user = new UserBusiness(s1, s2, s3);
                    user.setPassrecov(s4);
                }
                login(event);
            }
        }
    }

    @FXML
    protected void login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
