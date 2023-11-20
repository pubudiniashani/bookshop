package lk.ijse.bookshop.model;


import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.CustomerDto;
import lk.ijse.bookshop.dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderModel {

    public boolean saveOrder(String orderId , String cusId , String amount , int quantity) throws SQLException {

     Connection connection =  DbConnection.getInstance().getConnection();

     String sql = "INSERT INTO orders VALUES(?,?,?,?)";
     PreparedStatement pstm = connection.prepareStatement(sql);

     pstm.setString(1,orderId);
     pstm.setString(2,cusId);
     pstm.setString(3,amount);
     pstm.setString(4, String.valueOf(quantity));

     return  pstm.executeUpdate() > 0;
    }

    public boolean updateOrder(OrderDto dto) throws SQLException {
        Connection connection =  DbConnection.getInstance().getConnection();

        String sql = ("UPDATE orders SET cusId = ? , amount = ? , quantity = ? WHERE orderId = ?");
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getCusId());
        pstm.setString(2, dto.getAmount());
        pstm.setString(3, String.valueOf(dto.getQuantity()));
        pstm.setString(4, dto.getOrderId());

        return pstm.executeUpdate() > 0;
    }

    }
