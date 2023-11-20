package lk.ijse.bookshop.model;

import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.LoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public LoginDto getData() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql ="SELECT userName, password FROM  user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        LoginDto dto = null;
        while (resultSet.next()){
            dto = new LoginDto(resultSet.getString(1),resultSet.getString(2));
        }
       return dto ;
    }
}
