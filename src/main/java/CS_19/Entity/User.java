package CS_19.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id

     private int id;
     private String Name;
     private int Mobile_Number;

     private  String Email;
     private  String Password;

}
