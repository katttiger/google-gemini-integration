package se.iths.cecilia.googlegeminiintegration.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.cecilia.googlegeminiintegration.service.ChatService;

import java.util.HashMap;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public String returnHomePage(Model model) {
        HashMap<String, String> chatHistory = chatService.getChatHistory();
        model.addAttribute("chatHistory", chatHistory);
        return "index";
    }

    @PostMapping("/ask")
    public String sendPrompt(@RequestParam String prompt, Model model) {
        String response = chatService.sendPrompt(prompt);
        model.addAttribute("response", response);
        return "redirect:/";
    }
}
