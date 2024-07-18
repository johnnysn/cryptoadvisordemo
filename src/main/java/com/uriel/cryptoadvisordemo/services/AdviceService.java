package com.uriel.cryptoadvisordemo.services;

import com.uriel.cryptoadvisordemo.configurations.ChatProperties;
import com.uriel.cryptoadvisordemo.data.CryptoSymbol;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {

    private final OpenAiChatModel chatModel;
    private final ChatProperties chatProperties;

    public String overview(CryptoSymbol cryptoSymbol) {
        UserMessage userMessage = new UserMessage("""
                Give me a short overview of the current %s (%s) quotation followed by a brief trend assessment.
                """.formatted(cryptoSymbol.getTitle(), cryptoSymbol.name()));

        var chatResponse = getChatResponse(List.of(userMessage));
        return chatResponse.getResult().getOutput().getContent();
    }

    public String answer(String text) {
        SystemMessage systemMessage = new SystemMessage("""
                 You are a helpful AI assistant that provides insight into cryptocurrencies based
                 on realtime quotations. Answer the user question based on your knowledge about the
                 market and the available tools for retrieving quotation info as needed. If the user's
                 question has nothing to do with cryptocurrencies or the associated markets,
                 just say you don't know the answer.
                \s""");
        UserMessage userMessage = new UserMessage(text);

        return getChatResponse(List.of(systemMessage, userMessage))
                .getResult().getOutput().getContent();
    }

    private ChatResponse getChatResponse(List<Message> messages) {
        return chatModel.call(
                new Prompt(
                        messages,
                        OpenAiChatOptions.builder()
                                .withModel(chatProperties.getModel())
                                .withTemperature(chatProperties.getTemperature())
                                .withMaxTokens(chatProperties.getMaxTokens())
                                .withFunction("CurrentQuotation")
                                .build()
                )
        );
    }
}
