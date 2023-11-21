package esd.carlos.learningspring02.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyControllerTest {

    @Autowired
    MyController myController;

    @Test
    public void superGreeter() {
        myController.superGreeter();
    }

}