package lk.ijse.bookshop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

    private String empId;
    private String name;
    private String address;
    private String job;
    private String tel;

}
