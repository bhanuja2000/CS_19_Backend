package CS_19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;
    private String Name;
    private int Mobile_Number;

    private  String Email;
    private  String Password;
}
