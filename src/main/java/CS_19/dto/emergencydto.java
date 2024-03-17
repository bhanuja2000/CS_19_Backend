package CS_19.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class emergencydto {
    private int id;
    private Long latitude;
    private Long longitude;
    private String email;
}
