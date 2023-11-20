package lk.ijse.bookshop.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bookshop.model.ItemModel;

import java.io.IOException;

public class ItemFormController {


    public Button btnBook;
    public Button btnStationery;
    private ItemModel model;

    public void initialize(){
    }


    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/book_form.fxml"));

      

      //  this.root.getChildren().clear();
        //this.root.getChildren().add(node);
    }

    public void btnStationeryOnAction(ActionEvent actionEvent) {
    }
}
