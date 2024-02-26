package com.alphonse.banque.config.securite.services;

import com.alphonse.banque.models.User;
import com.alphonse.banque.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User userOptional = userService.findUserByLogin(username);
        if (userOptional!=null){
            return  new UserDetailsImpl(userOptional);
        }
        return null;
    }
}
