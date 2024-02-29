package CS_19.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import CS_19.Entity.User;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class UserInfoconfig implements UserDetails {
    private final User userinfoE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return Arrays
                .stream(userinfoE
                        .getUser_role()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
       
        return userinfoE.getPassword();
    }

    @Override
    public String getUsername() {
      return userinfoE.getEmail();
        
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}