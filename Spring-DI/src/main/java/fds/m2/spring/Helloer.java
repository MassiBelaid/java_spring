package fds.m2.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Helloer {
    @Autowired
    Printer printer;

    @Value("Salut de autopsie")
    private String message;

    public void sayHello(){
        printer.print(message);
    }
}
