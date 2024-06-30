package com.example.example.http.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/test/rest-template")
    public void testRestTemplate() {
        restTemplateService.requestRestTemplate();
    }

    @GetMapping("/api/rest-template")
    public RestTemplateResponse getRestTemplate(String url) {

        System.out.println("query param : " + url);

        return RestTemplateResponse.builder()
                .url(url)
                .title("get test")
                .description("test")
                .body(null)
                .build();
    }
}
