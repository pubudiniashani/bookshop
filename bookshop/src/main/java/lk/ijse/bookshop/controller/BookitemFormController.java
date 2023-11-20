package lk.ijse.bookshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.bookshop.dto.BookDto;
import lk.ijse.bookshop.dto.tm.BookTm;
import lk.ijse.bookshop.model.BookModel;

import java.sql.SQLException;

public class BookitemFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtLanguage;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TableView<BookTm> tblBook;

    private BookModel model = new BookModel();


    public void initialize(){
        tableListener();
    }

    private void tableListener() {
        tblBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValued, newValue) -> {
//            System.out.println(newValue);
            setData(newValue);
        });
    }

    private void setData(BookTm row) {
        txtId.setText(row.getItemId());
        txtName.setText(row.getName());
        txtPrice.setText(String.valueOf(row.getPrice ()));
        txtQuantity.setText(String.valueOf(row.getQuantity()));
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQuantity.getText());
        String isbn = txtIsbn.getText();
        String publisher = txtPublisher.getText();
        String genre = txtGenre.getText();
        String language = txtLanguage.getText();

        var dto = new BookDto(id,name,price,qty,isbn,publisher,genre,language);
        try {
            boolean isAdd = model.addBook(dto);
            if(isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,"Book is added").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR);
        }


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        boolean iDelete = model.deleteBook();

    /*if (iDelete){
        new Alert(Alert.AlertType.CONFIRMATION,"customer deleted").show();
    }else {
        new Alert(Alert.AlertType.ERROR,"customer deletion failed").show();
    }

    }*/
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtIsbn.setText("");
        txtPublisher.setText("");
        txtGenre.setText("");
        txtLanguage.setText("");
    }
}
