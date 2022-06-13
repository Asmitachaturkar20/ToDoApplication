package com.Auther.security_system;

import com.Auther.security_system.model.CustomUserDetail;
import com.Auther.security_system.model.User;
import com.Auther.security_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetalisService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(name);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return optionalUser.map(CustomUserDetail::new).get();
    }
}