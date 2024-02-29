package CS_19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class UserDto {

    private int id;
    private String Name;

    private  String Email;
    private  String Password;
    private int mobile;
    private String User_role;
    

}
