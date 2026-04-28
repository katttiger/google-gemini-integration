package se.iths.cecilia.googlegeminiintegration.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.iths.cecilia.googlegeminiintegration.service.ChatService;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class ChatController {

    private final ChatService service;

    @GetMapping
    public String returnHomePage() {
        //        service.getChatHistory();
        return "index";
    }

    @PostMapping("/ask")
    public String sendPrompt(@RequestParam String prompt, Model model) {
        String response = service.sendPrompt(prompt);
        model.addAttribute("response", response);
        return "index";
    }
}
