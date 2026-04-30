package se.iths.cecilia.googlegeminiintegration.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.cecilia.googlegeminiintegration.entity.Chat;
import se.iths.cecilia.googlegeminiintegration.repository.ChatRepository;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final Client client;

    public String sendPrompt(String prompt) {
        long attempts = 0L;
        while (attempts < 3) {

            try {
                GenerateContentResponse response = client.models.generateContent(
                        "gemini-3-flash-preview",
                        prompt,
                        null
                );
                Chat chat = new Chat(prompt, response);
                chatRepository.save(chat);

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

    public HashMap<String, String> getChatHistory() {
        List<Chat> chatItems = chatRepository.findAll();
        HashMap<String, String> chatHistory = new HashMap<>();
        for (Chat chatItem : chatItems) {
            chatHistory.put(chatItem.getPrompt(), chatItem.getResponse());
        }
        return chatHistory;
    }
}
