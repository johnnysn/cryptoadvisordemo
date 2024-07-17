package com.uriel.cryptoadvisordemo.services;

import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {

    private final OpenAiChatModel chatModel;

    public String generate(CryptoSymbol cryptoSymbol) {
        UserMessage userMessage = new UserMessage(
                """
                Give me a short overview of the current %s (%s) quotation followed by a brief trend assessment.
                """.formatted(cryptoSymbol.getTitle(), cryptoSymbol.name())
        );

        var chatResponse = chatModel.call(
                new Prompt(
                        List.of(userMessage),
                        OpenAiChatOptions.builder()
                                .withModel("gpt-3.5-turbo")
                                .withTemperature(0f)
                                .withFunction("CurrentQuotation")
                                .build()
                )
        );
        return chatResponse.getResult().getOutput().getContent();
    }
}
