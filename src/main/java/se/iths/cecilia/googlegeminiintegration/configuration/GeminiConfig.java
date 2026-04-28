package se.iths.cecilia.googlegeminiintegration.configuration;

import com.google.genai.Client;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    @ConditionalOnProperty(name = "gemini.enabled", havingValue = "true", matchIfMissing = true)
    public Client client() {
        return new Client();
    }

}
