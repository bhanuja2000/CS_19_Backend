package CS_19.Service;

import CS_19.Entity.User;
import CS_19.dto.UserDto;
import CS_19.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UService {
    @Autowired
   private UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    public UserDto savedata(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, User.class));
        return  userDto;
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
    public UserDto get_user_byId(String userId){
        User user=userRepo.get_selected_user(userId);
        return modelMapper.map(user,UserDto.class);
    }
    public UserDto getuserBy_Email(String email){
        User user=userRepo.get_selected_address_id(email);
        return modelMapper.map(user,UserDto.class);
    }
}
