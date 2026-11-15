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

        ChatResponse response = model.chat(UserMessage.from("Quelle est la capitale de la France ?"));

        System.out.println(response.aiMessage().text());

        TokenUsage usage = response.tokenUsage();
        System.out.println("Tokens en entrée : " + usage.inputTokenCount());
        System.out.println("Tokens en sortie : " + usage.outputTokenCount());
        System.out.println("Total : " + usage.totalTokenCount());
    }
}