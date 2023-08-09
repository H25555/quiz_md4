package com.example.quiz_md4.service.auth;

import com.example.quiz_md4.model.User;
import com.example.quiz_md4.repository.UserRepository;
import com.example.quiz_md4.service.auth.request.RegisterRequest;
import com.example.quiz_md4.util.AppUtils;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    public void register(RegisterRequest request) {
        var user = AppUtils.mapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exist!"));
        var role = new ArrayList<SimpleGrantedAuthority>();
        role.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), role);
    }

    public boolean checkEmail(RegisterRequest request, BindingResult result){
        boolean check = false;
        if(userRepository.existsByEmailIgnoreCase(request.getEmail())){
            result.reject("email", null,
                    "There is already an account registered with the same email");
            check = true;
        }
        return check;
    }
}
