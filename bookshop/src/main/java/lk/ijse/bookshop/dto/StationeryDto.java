package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StationeryDto {
    private String itemId;
    private String name;
    private double price;
    private int quantity;
    private String category;
}
