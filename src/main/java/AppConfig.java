import beans.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by arpi on 05.11.2016.
 */
@Configuration
@Import(LoggersConfig.class)
public class AppConfig {




    @Bean
    public Client client(@Value("${id}") String id){
        Client client = new Client();
        client.setGreeting("${greeting}");

        //String id;
        return new Client(id,"${fullName}");
    }
}
