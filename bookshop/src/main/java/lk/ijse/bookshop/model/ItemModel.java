package lk.ijse.bookshop.model;

import lk.ijse.bookshop.db.DbConnection;
import lk.ijse.bookshop.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {

    public List<ItemDto> loadAllItem() throws SQLException {
      Connection connection =  DbConnection.getInstance().getConnection();

      String sql = "SELECT * FROM item";
     PreparedStatement pstm = connection.prepareStatement(sql);

     List<ItemDto> itemList = new ArrayList<>();

     ResultSet rs = pstm.executeQuery();
     while(rs.next()){
         itemList.add(new ItemDto(
              rs.getString(1),
              rs.getString(2),
              rs.getString(3),
              rs.getDouble(4),
              rs.getInt(5),
              rs.getString(6),
              rs.getString(7),
              rs.getString(8),
              rs.getString(9),
              rs.getString(10)

         ));
        }
     return itemList;
     }






    public ItemDto searchItem(String code) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE itemId = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, code);

        ResultSet resultSet = pstm.executeQuery();

        ItemDto dto = null;

        if(resultSet.next()) {
            dto = new ItemDto(

            );
        }
        return dto;
    }

    public boolean updateItem(ItemDto itemDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE item SET isbn = ?, publisher = ?, qty_on_hand = ? WHERE type = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);



        return pstm.executeUpdate() > 0;
    }


    public void addBook() {

    }
}



