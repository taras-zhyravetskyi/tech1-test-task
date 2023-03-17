package com.tech1test.service.impl;

import com.tech1test.dao.UserCredentialsRepository;
import com.tech1test.entity.UserCredentials;
import com.tech1test.service.UserCredentialsService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialsServiceImpl implements UserCredentialsService {
    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserCredentials save(UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    @Override
    public Optional<UserCredentials> findByEmail(String email) {
        return Optional.ofNullable(userCredentialsRepository.findByEmail(email));
    }
}
