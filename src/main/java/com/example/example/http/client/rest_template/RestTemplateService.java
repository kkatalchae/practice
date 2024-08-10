package com.example.example.http.client.rest_template;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public void requestRestTemplate() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")
                .path("/api/test")
                .queryParam("url", "http://localhost:8080")
                .build()
                .toUri();

        ResponseEntity<ResponseDto> response = restTemplate.getForEntity(uri, ResponseDto.class);

        System.out.println(response.getBody().toString());
    }
}
