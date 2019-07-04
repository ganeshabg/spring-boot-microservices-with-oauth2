package com.example.oauth2.authorizationserver.model.security;

import com.example.oauth2.authorizationserver.model.Role;
import com.example.oauth2.authorizationserver.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPrinciple implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user!=null && user.getRoles()!=null){
            user.getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getName()));
                role.getPermissions().forEach(permission->{
                    authorities.add(new SimpleGrantedAuthority(permission.getName()));
                });
            });
        }
        return  authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNonExpired()==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNonLocked()==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNonExpired()==1;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled()==1;
    }
}
