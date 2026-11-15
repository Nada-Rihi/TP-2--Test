package com.nadarihi;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.output.TokenUsage;

public class Test2Couts {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        // Code original (Test 2 : coût en tokens)
        // ChatResponse response = model.chat(UserMessage.from("Quelle est la capitale de la France ?"));

        // Nouveau code (Test 7 : question sur le parapluie, sans outil)
        ChatResponse response = model.chat(UserMessage.from(
                "Je dois partir dans 2 jours à Paris ; j'y resterai 3 jours. Est-ce que je dois mettre un parapluie dans mes valises ?"));

        System.out.println(response.aiMessage().text());

        TokenUsage usage = response.tokenUsage();
        System.out.println("Tokens en entrée : " + usage.inputTokenCount());
        System.out.println("Tokens en sortie : " + usage.outputTokenCount());
        System.out.println("Total : " + usage.totalTokenCount());
    }
}