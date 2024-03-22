package CS_19.controller;

import CS_19.Entity.preferred_contact;
import CS_19.Service.UserSerivice;
import CS_19.dto.UserRegistrationDto;
import CS_19.dto.maildto;
import CS_19.dto.userdetailsdto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DashboardController {
    @Autowired
    private UserSerivice userSerivice;

    //@PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/welcome-message")
    public ResponseEntity<String> getFirstWelcomeMessage(Authentication authentication) {
        return ResponseEntity.ok("Welcome to the JWT Tutorial:" + authentication.getName() + "with scope:" + authentication.getAuthorities());
    }

    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/manager-message")
    public ResponseEntity<String> getManagerData(Principal principal) {
        return ResponseEntity.ok("Manager::" + principal.getName());

    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/admin-message")
    public ResponseEntity<String> getAdminData(@RequestParam("message") String message, Principal principal) {
        return ResponseEntity.ok("Admin::" + principal.getName() + " has this message:" + message);

    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @GetMapping("/work")
    public String exaple() {
        return "e";
    }

    @GetMapping("/get/user")
    public List<userdetailsdto> dispaly() {
        return userSerivice.getdata();
    }

    @PostMapping("send/email")
    public String post_emai(@RequestBody maildto Maildto) {
        return userSerivice.mailsender(Maildto);
    }

    @PostMapping("/getUsers")
    public List<UserRegistrationDto> getUser() {
        return userSerivice.getAllUsers();
    }

   @PostMapping("/findemail")
    public userdetailsdto getById(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        return userSerivice.getdatafromemail(email);
    }
    @PostMapping("/action/{email}")
    public String triger(@RequestBody Map<String,Long> request,@PathVariable String email){

        Long latitude=request.get("latitude");
        Long longitude=request.get("longitude");
        return userSerivice.action(email, latitude,longitude);
    }
   @PostMapping("/addconcs")
    public String Add_contcs(@RequestBody Map<String,String> request){
        String user=request.get("Uemail");
        String prefredcontcs=request.get("pmail");
        return userSerivice.add_contact(user,prefredcontcs);
   }
    @GetMapping("/user1/{userEmail}")
    public ResponseEntity<List<preferred_contact>> getAllPreferredContactsByUserEmail(@PathVariable String userEmail) {
        List<preferred_contact > preferredContacts = userSerivice.getAllPreferredContactsByUserEmail(userEmail);
        return ResponseEntity.ok(preferredContacts);
    }
    @PostMapping("/emailfound")
    public  String emailcheck(@RequestBody Map<String,String>request){
        String email=request.get("email");
        return userSerivice.emailcheck(email);
    }
    @PostMapping("/passwordreset")
    public  String uppassword(@RequestBody Map<String,String>request){
        String email=request.get("email");
        String password=request.get("password");
        return userSerivice.updatepasswor(email,password);
    }
    @PostMapping("/confomation")
    public  boolean confomcheck(@RequestBody Map<String, Integer>request){
      int number=request.get("confomation");
      return userSerivice.checkconfomationnumbercorrect(number);
    }


}

