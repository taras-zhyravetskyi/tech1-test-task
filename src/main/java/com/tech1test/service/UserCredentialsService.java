package com.tech1test.service;

import com.tech1test.entity.UserCredentials;
import java.util.Optional;

public interface UserCredentialsService {
    UserCredentials save(UserCredentials userCredentials);

    Optional<UserCredentials> findByEmail(String email);
}
