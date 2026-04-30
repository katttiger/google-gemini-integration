package se.iths.cecilia.googlegeminiintegration.entity;

import com.google.genai.types.GenerateContentResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, name = "prompt")
    private String prompt;

    @Column(nullable = false, name = "response")
    private String response;

    @Column(name = "datetimesent", nullable = false)
    private LocalDateTime dateTimeSent;

    public Chat(String prompt, GenerateContentResponse response) {
        this.prompt = prompt;
        this.response = response.text();
        this.dateTimeSent = LocalDateTime.now();
    }
}
