package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {

    private String itemId;
    private String name;
    private double price;
    private int quantity;
    private String isbn;
    private String publisher;
    private String genre;
    private String language;
}
