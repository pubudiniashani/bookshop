package lk.ijse.bookshop.model;

import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.BookDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookModel {
    public boolean addBook(BookDto dto) throws SQLException {

       Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer(itemId,name,price,quantity,isbn,publisher,genre,language) VALUES (?,?,?,?,?,?,?,?)");
        pstm.setString(1,dto.getItemId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, String.valueOf(dto.getPrice()));
        pstm.setString(4, String.valueOf(dto.getQuantity()));
        pstm.setString(5, dto.getIsbn());
        pstm.setString(6, dto.getPublisher());
        pstm.setString(7, dto.getGenre());
        pstm.setString(8, dto.getLanguage());


        return pstm.executeUpdate() >0 ;
    }


    public boolean deleteBook() {
        return false;
    }
}
