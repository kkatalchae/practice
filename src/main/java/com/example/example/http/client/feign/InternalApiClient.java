package com.example.example.http.client.feign;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "InternalApiClient", url = "http://localhost:8080")
public interface InternalApiClient {

    @GetMapping("/api/test")
    Response get();
}
