package esd.carlos.learningspring02;

import esd.carlos.learningspring02.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningSpring02Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LearningSpring02Application.class, args);
        MyController controller = ctx.getBean(MyController.class);
        controller.demo();
    }

}
