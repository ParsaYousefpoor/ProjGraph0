package Login;

import Source.User;
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

public class Forgot {
    User user = HelloApplication.user;
    boolean flag = false;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private TextField ans;
    @FXML
    private TextField tp;
    @FXML
    private TextField tr;


    @FXML
    protected void check(ActionEvent event) throws IOException {
        if (!flag) {
            ansCheck();
        } else {
            passUpdate(event);
        }
    }

    protected void ansCheck() {
        String s1 = ans.getText();
        if (s1 != null) {
            if (user.getPassrecov().equals(s1)) {
                ans.setVisible(false);
                label1.setVisible(false);
                tp.setVisible(true);
                tr.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
                label4.setVisible(false);
                flag = true;
            } else {
                label4.setVisible(true);
            }
        }
    }

    protected void passUpdate(ActionEvent event) throws IOException {
        String s1 = tp.getText();
        String s2 = tr.getText();
        if (s1 != null && s2 != null) {
            if (!s1.equals(s2)) {
                label2.setText("Two fields must be the same");
            } else if (s1.length() < 8) {
                label2.setText("Password must be at least 8 character");
            } else if (s1.equals(user.getPassword())) {
                label2.setText("New password must be different from old one");
            } else {
                user.setPassword(s1);
                changeScene(event);
            }
        }
    }

    protected void changeScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
