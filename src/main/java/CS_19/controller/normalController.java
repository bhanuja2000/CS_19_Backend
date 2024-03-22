package CS_19.controller;

import CS_19.Service.UserSerivice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api2")
@RequiredArgsConstructor
public class normalController {
    @Autowired
    private UserSerivice userSerivice;
    @PostMapping("/passwordreset")
    public  String uppassword(@RequestBody Map<String,String> request){
        String email=request.get("email");
        String password=request.get("password");
        return userSerivice.updatepasswor(email,password);
    }
    @PostMapping("/confomation")
    public  boolean confomcheck(@RequestBody Map<String, Integer>request){
        int number=request.get("confomation");
        return userSerivice.checkconfomationnumbercorrect(number);
    }
    @PostMapping("/emailfound")
    public  String emailcheck(@RequestBody Map<String,String>request){
        String email=request.get("email");
        return userSerivice.emailcheck(email);
    }
}
