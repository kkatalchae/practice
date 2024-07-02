package com.example.example.http.client;

import com.example.example.http.client.feign.InternalApiClient;
import com.example.example.http.client.rest_template.ResponseDto;
import com.example.example.http.client.rest_template.RestTemplateService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class TestApiController {

    private final RestTemplateService restTemplateService;

    private final InternalApiClient internalApiClient;

    @GetMapping("/test/rest-template")
    public void testRestTemplate() {
        restTemplateService.requestRestTemplate();
    }

    @GetMapping("/test/feign-client")
    public void testFeignClient() throws URISyntaxException {

        Response response = internalApiClient.get();

        System.out.println(response);
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
