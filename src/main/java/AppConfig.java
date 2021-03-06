import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.CacheFileEventLogger;
import loggers.CombinedEventLogger;
import loggers.ConsoleEventLogger;
import loggers.IEventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by arpi on 05.11.2016.
 */
@Configuration
@Import(LoggersConfig.class)
@PropertySource(value = {"client.properties"}, ignoreResourceNotFound = true)
public class AppConfig {
    @Value("${fullName}")
    String fullName;
    @Value("${id}")
    String id;
    @Value("${greeting}")
    String greeting;

    @Bean
    public Client client() {
        Client client = new Client(this.id, this.fullName);
        client.setGreeting(this.greeting);
        client.setType(Math.PI);
        return client;
    }

    @Bean
    public App app(@Qualifier("client") Client client, @Qualifier("cacheFileEventLogger") CacheFileEventLogger cacheFileEventLogger,
                   @Qualifier("consoleEventLogger") ConsoleEventLogger consoleEventLogger,
                   @Qualifier("combinedEventLogger") CombinedEventLogger combinedEventLogger) {
        Map<EventType, IEventLogger> map = new HashMap<EventType, IEventLogger>();
        map.put(EventType.INFO, consoleEventLogger);
        map.put(EventType.ERROR, combinedEventLogger);
        App app = new App(client, cacheFileEventLogger, map);
        app.setType(null);
        return app;
    }

    @Bean
    @Scope("prototype")
    public Event event(){
        return new Event(new Date(), DateFormat.getDateTimeInstance());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer ppc() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
