package esd.carlos.learningspring02.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Objects;

@Profile("ES")
@SpringBootTest
class GreetingImplTest {
    @Autowired
    GreetingImpl greeting;
    
    @Test
    void sayHello() {
        String result = greeting.sayHello("carlos");
        assert (Objects.equals(result, "hola carlos2"));
    }
    
}