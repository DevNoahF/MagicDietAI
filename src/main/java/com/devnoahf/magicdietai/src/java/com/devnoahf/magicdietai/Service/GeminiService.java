package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.dto.FoodItemRequestDTO;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.dto.UserRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;

    private final String apiKey =System.getenv("API_KEY");

    public GeminiService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models")
                .build();
    }

    public Mono<String> generateRecipe(List<FoodItemRequestDTO> foodItems, List<UserRequestDTO> users) {
        String foods = foodItems.stream()
                .map(item -> String.format("%s (%s): %d quantidade(s), validade: %s",
                        item.nameFood(),
                        item.category(),
                        item.amount(),
                        item.validity().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                .collect(Collectors.joining("\n"));

        String user = users.stream()
                .map(userInfo -> String.format("Diet: %s",
                        userInfo.diet()))
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado na diet do usuário: " + user +
                ", faça uma receita com os seguintes itens: " + foods;

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", "Você é um assistente de receitas culinárias."),
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        return webClient.post()
                .uri("/gemini-1.5-flash:generateContent?key=" + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
}

