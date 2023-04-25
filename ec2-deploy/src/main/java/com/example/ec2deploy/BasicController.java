package com.example.ec2deploy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BasicController {
    @GetMapping("/test")
    public String home(){
        return "Hello from Ec2 Instance";
    }

}
