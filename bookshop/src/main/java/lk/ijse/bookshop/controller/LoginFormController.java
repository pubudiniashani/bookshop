package lk.ijse.bookshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bookshop.dto.LoginDto;
import lk.ijse.bookshop.model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {


    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPw;

    @FXML
    private TextField txtUsername;



    private LoginModel model = new LoginModel();

    private Stage stage;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
      String pw =  txtPw.getText();


        try {
            LoginDto dto = model.getData();
            if(dto!= null){
                if(dto.getUserName().equals(username)&& dto.getPw().equals(pw)){
                    AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
                    Scene scene = new Scene(anchorPane);
                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Dashboard");
                    stage.centerOnScreen();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSignupOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/signup_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("SignUp");
        stage.centerOnScreen();


    }
}
