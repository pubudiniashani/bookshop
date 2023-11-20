package lk.ijse.bookshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnSignupOnAction(ActionEvent event) throws IOException {
        String name =  txtName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Luminex Bookshop Management System");
        stage.centerOnScreen();
    }

    @FXML
    void btnSwitchLoginOnAction (ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.centerOnScreen();
    }
}
