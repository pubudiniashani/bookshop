package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierDto {

    private String supId;
    private String name;
    private  String address;
    private String tel;
}
