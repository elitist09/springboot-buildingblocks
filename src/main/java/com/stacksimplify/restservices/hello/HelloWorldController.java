package com.stacksimplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails helloWorldBean(){
        return new UserDetails("negro","venoso", "res");
    }
}
