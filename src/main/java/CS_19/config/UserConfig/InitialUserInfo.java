package CS_19.config.UserConfig;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import CS_19.Entity.User;
import CS_19.repo.UserRepo;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j

public class InitialUserInfo  implements CommandLineRunner {
    private  final   UserRepo userinfoEReop;
    private  final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        User manager=new User();
        manager.setName("Manager");
        manager.setPassword(passwordEncoder.encode("password"));
        manager.setUser_role("ROLE_MANAGER");
        manager.setEmail("manager@manager.com");

        User admin = new User();
        admin.setName("Admin");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setUser_role("ROLE_ADMIN");
        admin.setEmail("admin@admin.com");

        User user = new User();
        user.setName("User");
        user.setPassword(passwordEncoder.encode("password"));
        user.setUser_role("ROLE_USER");
        user.setEmail("user@user.com");

       userinfoEReop .saveAll(List.of(manager,admin,user));


    }

}