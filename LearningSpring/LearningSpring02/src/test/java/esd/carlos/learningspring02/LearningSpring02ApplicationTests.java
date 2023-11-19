package esd.carlos.learningspring02;

import esd.carlos.learningspring02.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class LearningSpring02ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyController myController;


    @Test
    void getControllerFromAutowired() {
        assert (myController.demo() == "vamos");
    }

    @Test
    void getControllerFromCtx() {
        MyController myController = applicationContext.getBean(MyController.class);
        assert (myController.demo() == "vamos");
    }

    @Test
    void contextLoads() {
    }

}
