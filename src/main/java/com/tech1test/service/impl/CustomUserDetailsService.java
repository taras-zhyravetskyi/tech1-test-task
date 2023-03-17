package com.tech1test.service.impl;

import static org.springframework.security.core.userdetails.User.UserBuilder;
import static org.springframework.security.core.userdetails.User.withUsername;

import com.tech1test.entity.UserCredentials;
import com.tech1test.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class CustomUserDetailsService implements UserDetailsService {
    private UserCredentialsService userCredentialsService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsService.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Incorrect email or password!"));
        UserBuilder builder = withUsername(email);
        builder.password(userCredentials.getPassword());
        builder.roles("USER");
        return builder.build();
    }
}
