package lk.ijse.bookshop.dto.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemTm {
    private String itemId;
    private String name;
    private String type;
    private double price;
    private int quantity;

}
