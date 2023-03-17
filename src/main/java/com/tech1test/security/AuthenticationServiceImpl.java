package com.tech1test.security;

import com.tech1test.entity.UserCredentials;
import com.tech1test.exception.AuthenticationException;
import com.tech1test.service.UserCredentialsService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserCredentialsService userCredentialsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCredentials register(String email, String password) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEmail(email);
        userCredentials.setPassword(passwordEncoder.encode(password));
        return userCredentialsService.save(userCredentials);
    }

    @Override
    public UserCredentials login(String login, String password) throws AuthenticationException {
        Optional<UserCredentials> userCredentials = userCredentialsService.findByEmail(login);
        String encodedPassword = passwordEncoder.encode(password);
        if (!userCredentials.isPresent()
                || !BCrypt.checkpw(password, userCredentials.get().getPassword())) {
            throw new AuthenticationException("Incorrect email or password!");
        }
        return userCredentials.get();
    }
}
