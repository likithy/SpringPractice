package com.pratice.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
  public boolean authenticate(String user, String password) {
    return user.equalsIgnoreCase("Likith") && password.equalsIgnoreCase("hi");
  }
}
