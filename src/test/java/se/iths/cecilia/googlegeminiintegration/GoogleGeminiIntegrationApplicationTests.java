package se.iths.cecilia.googlegeminiintegration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import se.iths.cecilia.googlegeminiintegration.configuration.GeminiConfig;

@SpringBootTest
@Import(GeminiConfig.class)
class GoogleGeminiIntegrationApplicationTests {

    @Test
    void contextLoads() {
    }

}
