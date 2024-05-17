package com.softtek.Mayo16SpSecurity.service;


import com.softtek.Mayo16SpSecurity.dao.request.SignInRequest;
import com.softtek.Mayo16SpSecurity.dao.request.SignUpRequest;
import com.softtek.Mayo16SpSecurity.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);

}
