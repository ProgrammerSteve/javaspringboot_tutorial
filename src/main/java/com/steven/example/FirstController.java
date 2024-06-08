package com.steven.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {


//    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from my first controller";
    }

    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2(){
        return "Hello 2 from my first controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "Request Accepted and message is: "+message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ){
        return "Request Accepted and order is: "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ){
        return "Request Accepted and order is: "+order.toString();
    }

    // http://localhost:8080/hello/steven
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name")  String userName
    ){
        return "my value= "+userName;
    }

    // http://localhost:8080/hello?param_name=paramvalue&param_name2=paramvalue2
    @GetMapping("/hello")
    public String pathVar(
            @RequestParam("name")  String userName,
            @RequestParam("last-name")  String userLastName
    ){
        return "my value= "+userName+" "+userLastName;
    }
}
