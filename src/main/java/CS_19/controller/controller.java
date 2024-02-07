package CS_19.controller;

import CS_19.Service.UService;
import CS_19.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v/user")
@CrossOrigin
public class controller {
    @Autowired
    private  UService uService;
   @GetMapping("/get/user")
   public List<UserDto> dispaly(){
     return uService.getdata();
   }

   @PostMapping("/post/user")
   public UserDto post(@RequestBody UserDto userDto){

       uService.savedata(userDto);
       return userDto;
   }
   @PutMapping("update/user")
   public UserDto update_user(@RequestBody UserDto userDto){
       uService.update(userDto);
       return userDto;
   }
   @DeleteMapping("/delete/user")
   public boolean delete_user(@RequestBody UserDto userDto){
     return uService.delete_by_user(userDto);
   }
   @GetMapping("withID/{userid}")

    public UserDto  get_details_with_userID(@PathVariable String userid){
       return uService.get_user_byId(userid);
   }
   @GetMapping("details/{email}")
   public  UserDto get_details_id_email(@PathVariable String email){
       return uService.getuserBy_Email(email);
   }

}
