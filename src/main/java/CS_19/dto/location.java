package CS_19.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;


    private String Time;

    private  String Latitude;
    private  String Longitude;
 
  

}

    

