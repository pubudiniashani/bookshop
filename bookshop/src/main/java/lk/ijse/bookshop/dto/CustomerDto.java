package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

    private String cusId;

    private String name;

    private String address;

    private String contactNumber;
}
