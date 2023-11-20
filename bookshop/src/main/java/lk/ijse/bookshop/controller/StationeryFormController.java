package lk.ijse.bookshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.bookshop.dto.StationeryDto;
import lk.ijse.bookshop.model.StationeryModel;

public class StationeryFormController {
    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnClear;

    private StationeryModel model = new StationeryModel();

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        String category = txtCategory.getText();

        var dto = new StationeryDto(id,name,price,qty,category);

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
}
