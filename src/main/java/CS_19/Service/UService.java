package CS_19.Service;

import CS_19.Entity.User;
import CS_19.dto.UserDto;
import CS_19.mail_details.maildto;

import CS_19.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@Transactional
public class UService {
    @Autowired
   private UserRepo userRepo;
    @Autowired
   private ModelMapper modelMapper;




   


    public String savedata(UserDto userDto){
        if (userRepo.existsById(userDto.getId())) {
            return "Aleady Exite";
        }
        else{
           
            User user=new User();
            user.setId(userDto.getId());
            user.setEmail(userDto.getEmail());
           user.setPassword(userDto.getPassword());
            user.setName(userDto.getName());
            user.setMobile(userDto.getMobile());
            user.setUser_role(userDto.getUser_role());
            
            userRepo.save(user);
        
           // userRepo.save(modelMapper.map(userDto,User.class ));
           return "registation sucsess";
        }
     
        
    }
    public List<UserDto>getdata(){
        List<User> userList=userRepo.findAll();

        return modelMapper.map(userList,new TypeToken<List<UserDto>>(){}.getType());
    }
    public UserDto update(UserDto userDto){
        userRepo.save(modelMapper.map(userDto,User.class));
        return  userDto;
    }
    public  boolean delete_by_user(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto,User.class));
        return true;
    }

    // public UserDto getdetailby_name(String name){
    //     User user=userRepo.getUserByname(name);
    //     UserDto nuser=new UserDto();
    //     nuser.setEmail(user.getEmail());
    //     nuser.setPassword(user.getPassword());
    //     nuser.setMobile(user.getMobile());
    //     nuser.setId(user.getId());
    //     nuser.setName(user.getName());
    //     return nuser;
    // }
    @Autowired
    private JavaMailSender javaMailSender;
    public String mailsender(maildto Maildto){
        try{
        SimpleMailMessage message=new SimpleMailMessage();
        message.setSubject(Maildto.getSubject());
        message.setTo(Maildto.getTomail());
        message.setText(Maildto.getMessage());
        message.setFrom(Maildto.getFrom());
        javaMailSender.send(message);
        return "sucess";
        }catch(Exception e){
        return e.getMessage();
        }


    }
    // public UserDto findby_email(String email){
    //     User user=userRepo.get_selected_address_id(email);
    //     return modelMapper.map(user,UserDto.class);
    // }

}
