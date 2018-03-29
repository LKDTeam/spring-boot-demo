package com.example.demo.resource;


import com.example.demo.annotation.MyAnnotation;
import com.example.demo.domain.ThreadLocalUtil;
import com.example.demo.domain.User;
import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@MyAnnotation
public class MyResource {

  @PostMapping("/hello")
  public String sayHello(@RequestBody User user) {
    User userLocal = ThreadLocalUtil.getUser();
    return userLocal.getName() + " say Hello to " + user.getName();
  }

  @GetMapping("/str")
  public String getStr() {
    return "Hello World";
  }

  @GetMapping("/user")
  public User getUser() {
    return ThreadLocalUtil.getUser();
  }

  @GetMapping("/ex")
  public void throwEx() throws MyException {
    throw new MyException("发生异常了");
  }

}
