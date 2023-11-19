package esd.carlos.learningspring02.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String demo() {
        System.out.println("vamos");
        return "vamos";
    }
}
