package lk.ijse.bookshop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookshop.dto.CustomerDto;
import lk.ijse.bookshop.dto.tm.CustomerTm;
import lk.ijse.bookshop.model.CustomerModel;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerFormController {

    public TextField txtId;
    public TextField txtAdd;
    public TextField txtContact;
    public TextField txtName;
    public Button btnClear;
    public Button btnUpdate;
    public Button btnSave;
    public Button btnDelete;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;

    private CustomerModel cusModel = new CustomerModel();

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
    }

    private void loadAllCustomer() {

        var model = new CustomerModel();
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList =  model.getAllCustomer();
            for (CustomerDto dto: dtoList ) {
                obList.add(
                        new CustomerTm(
                                dto.getCusId(),
                                dto.getName(),
                                dto.getAddress()
                        )
                );
            }

            tblCustomer.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String cusId = txtId.getText();
        String name = txtName.getText();
        String address = txtAdd.getText();
        String contactNumber = txtContact.getText();

        var dto = new CustomerDto(cusId, name, address, contactNumber);

        boolean isValidate = validateCustomer();
        if(isValidate){
            new Alert(Alert.AlertType.CONFIRMATION,"customer saved");
            try {
                boolean isSaved = cusModel.saveCustomer(dto);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String cusId = txtId.getText();
        String name = txtName.getText();
        String address = txtAdd.getText();
        String contactNumber = txtContact.getText();

        var dto = new CustomerDto(cusId, name, address, contactNumber);

        boolean isValidate = validateCustomer();
        if(isValidate){
            new Alert(Alert.AlertType.CONFIRMATION,"customer saved");
            try {
                boolean isSaved = cusModel.saveCustomer(dto);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }


    }

    private boolean validateCustomer() {
      boolean matches =  Pattern.matches("[C][0-9]{3,}",txtId.getText());
        if(!matches){
            new Alert(Alert.AlertType.ERROR,"Invalid id").show();
            return false;
        }

       boolean matches1 = Pattern.matches("[A-Za-z]{4,}",txtName.getText());
        if(!matches1){
            new Alert(Alert.AlertType.ERROR,"Invalid name").show();
            return false;
        }
        boolean matches2 = Pattern.matches("[A-Za-z]{4,}",txtAdd.getText());
        if(!matches2) {
            new Alert(Alert.AlertType.ERROR, "Invalid address").show();
            return false;
        }

        boolean matches3 = Pattern.matches("[0-9]{10}",txtContact.getText());
        if(!matches3){
            new Alert(Alert.AlertType.ERROR,"Invalid number").show();
            return false;
        }

        return true;
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

        String cusId = txtId.getText();

        try {
            boolean isDeleted = cusModel.deleteCustomer(cusId);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer is deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Customer deletion unsuccessfull").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAdd.setText("");
        txtContact.setText("");

    }

}
