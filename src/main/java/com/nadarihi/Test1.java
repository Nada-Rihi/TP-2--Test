package com.nadarihi;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-3.5-flash")
                .temperature(0.7)
                .build();

        String reponse = model.chat("Comment s'appelle le chat de Pierre ?");
        System.out.println(reponse);
    }
}