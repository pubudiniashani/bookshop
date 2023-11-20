package lk.ijse.bookshop.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardFormController {


    public Button btnCustomer;
    public Button btnOrders;
    public Button btnEmployees;
    public Button btnSuppliers;
    public Button btnItem;


    @FXML
    private AnchorPane root;

    @FXML
    private Button btnLogout;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);


    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/employee_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);


    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);


    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);


    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) {

    }


}
