package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OrderDto {
    private String orderId;
    private String cusId;
    private String amount;
    private int quantity;
}
