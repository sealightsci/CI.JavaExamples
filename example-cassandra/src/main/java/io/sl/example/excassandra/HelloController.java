package io.sl.example.excassandra;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "SPring boot-cassandra application is running!!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Pressed hello :)";
    }

}