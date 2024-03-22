package CS_19.Service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import CS_19.Entity.EmergencyLocation;
import CS_19.Entity.UserInfoEntity;
import CS_19.Entity.preferred_contact;
import CS_19.dto.UserRegistrationDto;
import CS_19.dto.maildto;
import CS_19.dto.userdetailsdto;
import CS_19.repo.UserInfoRepo;
import CS_19.repo.emergencyrepo;
import CS_19.repo.preferredcobtacrepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSerivice {
    @Autowired
    UserInfoRepo repo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private emergencyrepo erepo;
    @Autowired
    private preferredcobtacrepo prep;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    int confomation_number;


    public List<userdetailsdto>getdata(){
        List<UserInfoEntity> userList=repo.findAll();
        List<userdetailsdto> userDtoList = userList.stream()
                .map(user -> {
                    userdetailsdto userDto = new userdetailsdto();
                    userDto.setUserMobileNo(user.getMobileNumber());
                    userDto.setUserName(user.getUserName());
                    userDto.setUserEmail(user.getEmailId());
                    userDto.setUserRole(user.getRoles());
                    // Map other fields as needed
                    return userDto;
                })
                .collect(Collectors.toList());
        return userDtoList;


    }
    public  userdetailsdto getdatafromemail(String email){
       UserInfoEntity user=repo.getUserByEmailID(email);
       userdetailsdto dto=new userdetailsdto();
       dto.setUserEmail(user.getEmailId());
       dto.setUserName(user.getUserName());
       dto.setUserMobileNo(user.getMobileNumber());
       dto.setUserRole(user.getRoles());
       return  dto;

    }
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
    public UserInfoEntity getUserById(String email) {
        // Assuming UserRepository has a method to find a user by ID
        return repo.findByEmailId(email).orElse(null);
    }
    public  String action(String email,long Latitude,long Longitude){
        try {
            UserInfoEntity user=repo.getUserByEmailID(email);
            EmergencyLocation location=new EmergencyLocation();
            location.setUser(user);
            location.setLatitude(Latitude);
            location.setLongitude(Longitude);
            erepo.save(location);
            return "okay";
        }catch(Exception e){
           return e.getMessage();
        }

    }
    public String add_contact(String U_email,String C_email){
        try {
            if (repo.existsByemailId(C_email)){
                preferred_contact  contcs=new preferred_contact();
                contcs.setUseremail(U_email);
                contcs.setContacts(C_email);
                prep.save(contcs);
                return "okay";
            }
            else {
                return "person_not avalable";
            }

        }catch(Exception e){
            return e.getMessage();
        }

    }
    public List<UserRegistrationDto> getAllUsers(){
        List<UserInfoEntity>userList=repo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserRegistrationDto>>(){}.getType());
    }
    public List<preferred_contact> getAllPreferredContactsByUserEmail(String userEmail) {
        return prep.findAllByuseremail(userEmail);
    }
    public  String emailcheck(String email){
        if (repo.existsByemailId(email)){
            try{
                SimpleMailMessage message=new SimpleMailMessage();
                message.setSubject("1020 Password reset ");
                message.setTo(email);
                message.setFrom("bhanujanimsara@gmail.com");
                Random random=new Random();
                confomation_number= random.nextInt(900)+1000;
                message.setText("Password Reset code"+confomation_number);
                javaMailSender.send(message);
                return "okay";
            }catch(Exception e){
                return e.getMessage();}



        }else {
            return "not found";
        }

    }
    public String  updatepasswor(String username,String newPaasword){
        try{
            UserInfoEntity user=repo.getUserByEmailID(username);
            String password=passwordEncoder.encode(newPaasword);
            user.setPassword(password);
            repo.save(user);
            return  "okay";
        }catch(Exception e){return e.getMessage();}


    }
    public boolean checkconfomationnumbercorrect(int user_entred_confomationnumber){
        if (confomation_number==user_entred_confomationnumber){
            return true;
        }
        else {
            return false;
        }
    }
}

