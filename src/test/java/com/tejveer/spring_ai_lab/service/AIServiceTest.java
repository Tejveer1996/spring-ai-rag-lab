package com.tejveer.spring_ai_lab.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AIServiceTest {

    @Autowired
    AIService aiService;

    @Test
    public void testChat(){
        var response = aiService.getChatResponse("joke");
        System.out.println(response);
    }

}
