package com.tejveer.spring_ai_lab.service;

import com.tejveer.spring_ai_lab.config.AIConfig;
import com.tejveer.spring_ai_lab.dto.ChatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    String systemPrompt = """
            Give brief answers in just 2 lines not more than that : {topic}
            """;


    public String getChatResponse(String topic){
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String renderedText = promptTemplate.render(Map.of("topic", topic));
        var response = chatClient.prompt()
                .user(renderedText)
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .entity(ChatResponseDto.class);
        return response.text();

    }
}
