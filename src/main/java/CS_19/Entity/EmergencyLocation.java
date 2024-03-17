package CS_19.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmergencyLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long latitude;
    private Long longitude;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UserInfoEntity user;
}
