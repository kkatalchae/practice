package com.example.example.http.client.web_client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebClientUtil {
    private final WebClientConfig webClientConfig;

    public <T> T get(String url, Class<T> responseDtoClass) {
        return webClientConfig.webClient().method(HttpMethod.GET)
                .uri(url)
                // retrieve : body only, exchange : httpStatus, headers, body
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(responseDtoClass);
                    }

                    return clientResponse.createError();
                })
                .block();
    }

    public <T, V> T post(String url, V requestDto, Class<T> responseDtoClass) {
        return webClientConfig.webClient().method(HttpMethod.POST)
                .uri(url)
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(responseDtoClass)
                .block();
    }
}
