package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by arpi on 30.10.2016.
 */
@Component("client")
@Scope("singleton")
public class Client {
    @Value("${id}")
    private String id;
    @Value("${fullName}")
    private String fullName;
    @Value("${greeting}")
    private String greeting;
    private float type;

    public void setType(float type) {
        this.type = type;
    }

    public Client() {
    }

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Client bean deleted----");
    }
}
