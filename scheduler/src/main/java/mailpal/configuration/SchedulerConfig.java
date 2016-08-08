package mailpal.configuration;

import com.mailpal.mail.connector.ImapConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tsv
 * @since 08.08.2016.
 */
@Configuration
public class SchedulerConfig {

    @Bean
    public ImapConnector imapConnector() {
        return new ImapConnector();
    }
}
