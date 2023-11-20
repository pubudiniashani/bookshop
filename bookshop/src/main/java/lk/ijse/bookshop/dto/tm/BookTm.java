package lk.ijse.bookshop.dto.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookTm {
    private String itemId;
    private String name;
    private double price;
    private int quantity;
}
