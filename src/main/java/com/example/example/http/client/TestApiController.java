package com.example.example.http.client;

import com.example.example.http.client.rest_template.ResponseDto;
import com.example.example.http.client.rest_template.RestTemplateService;
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

    @GetMapping("/api/test")
    public ResponseDto getTest(String url) {

        System.out.println("query param : " + url);

        return ResponseDto.builder()
                .url(url)
                .title("get test")
                .description("test")
                .body(null)
                .build();
    }
}
