package se.iths.cecilia.googlegeminiintegration.configuration;

import com.google.genai.Client;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
class GeminiConfigTest {

    @Bean
    public Client client() {
        return org.mockito.Mockito.mock(Client.class);
    }


}