package com.uriel.cryptoadvisordemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {

    private final OpenAiChatModel chatModel;

    public String generate() {
        var chatResponse = chatModel.call(
                new Prompt(
                        "Say a random phrase using only seven words.",
                        OpenAiChatOptions.builder()
                                .withModel("gpt-3.5-turbo")
                                .withTemperature(0.4f)
                                .build()
                )
        );
        return chatResponse.getResult().getOutput().getContent();
    }

}
