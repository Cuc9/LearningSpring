import beans.Client;
import beans.Event;
import loggers.IEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arpi on 30.10.2016.
 */
public class App {
    private Client client;
    private IEventLogger eventLogger;

    public App() {
    }

    public App(Client client, IEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg, Event event){
        String message = msg.replaceAll(client.getId(),client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        //app.client = new beans.Client("1","Vasya Pupkin");
        //app.eventLogger = new loggers.ConsoleEventLogger();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);
        for (int i = 0; i<5; i++){
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){}
            app.logEvent("Some event for user 1",(Event) ctx.getBean("event"));
        }
    }
}
