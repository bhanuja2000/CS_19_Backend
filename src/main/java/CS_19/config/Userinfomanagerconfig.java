package CS_19.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import CS_19.repo.UserRepo;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Userinfomanagerconfig implements UserDetailsService {
    private final UserRepo userinfoEReop;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        return userinfoEReop.findByEmail(emailId)
        .map(UserInfoconfig::new)
        .orElseThrow(()-> new UsernameNotFoundException("UserEmail: "+emailId+" does not exist"));
    }
    
}
