package com.pratice.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  private Logger log = LoggerFactory.getLogger(getClass());
  private AuthService authService;

  public LoginController(AuthService authService) {
    this.authService = authService;
  }

  @RequestMapping(value = "login",method = RequestMethod.GET)
  public String loginTO() {
    return "loginView/login";
  }

  @RequestMapping(value = "login",method = RequestMethod.POST)
  public String goToWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap modelMap) {
    modelMap.put("name",name);
    modelMap.put("password",password);

    //Auth
    if(!authService.authenticate(name,password)) return "loginView/login";
    return "Welcome";
  }

}
