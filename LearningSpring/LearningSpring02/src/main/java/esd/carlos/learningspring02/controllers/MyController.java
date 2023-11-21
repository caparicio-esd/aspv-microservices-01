package esd.carlos.learningspring02.controllers;

import esd.carlos.learningspring02.services.GreetingImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingImpl greetingService;

    public MyController(GreetingImpl greetingService) {
        this.greetingService = greetingService;
    }

    public void superGreeter() {
       System.out.println( this.greetingService.sayHello("carlos"));
    }

    public String demo() {
        System.out.println("vamos");
        return "vamos";
    }
}
