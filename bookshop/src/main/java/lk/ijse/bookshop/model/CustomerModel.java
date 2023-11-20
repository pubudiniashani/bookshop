package lk.ijse.bookshop.model;

import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public static List<CustomerDto> getCustomer() throws SQLException {
     Connection connection =  DbConnection.getInstance().getConnection();
     PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer");
     ResultSet rs = pstm.executeQuery();

     ArrayList<CustomerDto> list = new ArrayList<>();
     while(rs.next()){
         list.add(new CustomerDto(
                 rs.getString("cusId"),
                 rs.getString("name"),
                 rs.getString("address"),
                 rs.getString("contactNumber")

         ));

     }
     return list;
    }

public boolean saveCustomer(CustomerDto dto) throws SQLException {
      Connection connection =  DbConnection.getInstance().getConnection();
   PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer(cusId,name,address,contactNumber) VALUES (?,?,?,?)");
    pstm.setString(1,dto.getCusId());
    pstm.setString(2, dto.getName());
    pstm.setString(3, dto.getAddress());
    pstm.setString(4,dto.getContactNumber());

    return pstm.executeUpdate() >0 ;
}

public boolean deleteCustomer(String cusId) throws SQLException {
      Connection connection = DbConnection.getInstance().getConnection();
    PreparedStatement pstm =  connection.prepareStatement("DELETE FROM customer WHERE cusId=?");
    pstm.setString(1,cusId);

    return pstm.executeUpdate() > 0;
}

public  boolean updateCustomer(CustomerDto dto) throws SQLException {
      Connection connection =  DbConnection.getInstance().getConnection();

    String sql = ("UPDATE customer SET name = ? , address = ? , contactNumber = ? WHERE cusId = ?");
     PreparedStatement pstm = connection.prepareStatement(sql);


      pstm.setString(1, dto.getName());
      pstm.setString(2, dto.getAddress());
      pstm.setString(3, dto.getContactNumber());
      pstm.setString(4, dto.getCusId());

      return pstm.executeUpdate() > 0;
}

    public List<CustomerDto> getAllCustomer() throws SQLException {
       Connection connection = DbConnection.getInstance().getConnection();
       String sql = "SELECT * FROM customer";
       PreparedStatement pstm = connection.prepareStatement(sql);
     ResultSet rs =  pstm.executeQuery();

      ArrayList<CustomerDto>  dtoList = new ArrayList<>();
      while(rs.next()){
          dtoList.add(new CustomerDto(
                  rs.getString(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4)

          ));
      }
      return dtoList;
    }
}
