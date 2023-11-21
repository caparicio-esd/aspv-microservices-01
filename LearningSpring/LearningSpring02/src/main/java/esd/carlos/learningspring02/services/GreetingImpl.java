package esd.carlos.learningspring02.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "ES", "default"})
@Service // spring stereotype
public class GreetingImpl implements IGreeting {

    @Value("${focas}")
    String focas;

    @Override
    public String sayHello(String name) {
        return "hola " + name + focas;
    }
}
