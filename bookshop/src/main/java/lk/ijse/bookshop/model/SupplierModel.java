package lk.ijse.bookshop.model;

import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.SupplierDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SupplierModel {

    public static List<SupplierDto> getSupplier() throws SQLException {

       Connection connection = DbConnection.getInstance().getConnection();

       String sql = "SELECT * FROM supplier";
      PreparedStatement pstm =  connection.prepareStatement(sql);

     ResultSet rs = pstm.executeQuery();

      ArrayList<SupplierDto> list =  new ArrayList<>();

      while(rs.next()){
          list.add(new SupplierDto(
                rs.getString("supId"),
                  rs.getString("name"),
                  rs.getString("address"),
                  rs.getString("tel")

          ));
      }
      return list;
    }

    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        Connection connection =  DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO supplier(supId,name,address,tel) VALUES (?,?,?,?)");
        pstm.setString(1,dto.getSupId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4,dto.getTel());

        return pstm.executeUpdate() >0 ;
    }

    public boolean deleteSupplier(String supId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm =  connection.prepareStatement("DELETE FROM supplier WHERE supId=?");
        pstm.setString(1,supId);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        Connection connection =  DbConnection.getInstance().getConnection();

        String sql = ("UPDATE supplier SET name = ? , address = ? , tel = ? WHERE supId = ?");
        PreparedStatement pstm = connection.prepareStatement(sql);


        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTel());
        pstm.setString(4, dto.getSupId());

        return pstm.executeUpdate() > 0;
    }



}
