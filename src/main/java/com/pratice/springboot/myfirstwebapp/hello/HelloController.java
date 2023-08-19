package com.pratice.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

  @RequestMapping("say-hello")
  @ResponseBody
  public String sayHello() {
    return "Hello World";
  }

  @RequestMapping("say-hello-html")
  @ResponseBody
  public String sayHTML() {
    return "<html>"
        + "<head>"
        + "<title>My title</title>"
        + "</head>"
        + "<body>"
        + "HTML Page"
        + "</body>"
        + "</html>";
  }

  @RequestMapping("/say-hello-jsp")
  public String sayHelloJsp() {
    return "sayHello";
  }
}
