package com.tech1test.security;

import com.tech1test.entity.UserCredentials;
import com.tech1test.exception.AuthenticationException;

public interface AuthenticationService {
    UserCredentials register(String email, String password);

    UserCredentials login(String login, String password) throws AuthenticationException;
}
