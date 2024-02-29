package CS_19.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
     private String Name;

     private  String email;
     private  String Password;
     private int mobile;
     private String User_role;
  
    


}
