package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDto {

    private String itemId;
    private String name;
    private String type;
    private double price;
    private int quantity;
    private String isbn;
    private String publisher;
    private String genre;
    private String language;
    private String category;

}
