package se.iths.cecilia.googlegeminiintegration.configuration;

import com.google.genai.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public Client client() {
        return new Client();
    }

}
