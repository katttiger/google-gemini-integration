package se.iths.cecilia.googlegeminiintegration.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final
    Client client;

    public String sendPrompt(String prompt) {
        long attempts = 0L;
        while (attempts < 3) {

            try {
                GenerateContentResponse response = client.models.generateContent(
                        "gemini-3-flash-preview",
                        prompt,
                        null
                );
                return response.text();
            } catch (Exception e) {
                attempts++;
                try {
                    Thread.sleep(1000 * attempts);
                } catch (InterruptedException ignored) {
                }
            }
        }
        return "AI service is busy. Please try again later";
    }


    public void getChatHistory() {
    }
}
