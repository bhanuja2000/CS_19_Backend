package CS_19.mail_details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class maildto {
    private String tomail;
    private String  message;
    private String subject;
    private  String from;


    
}
