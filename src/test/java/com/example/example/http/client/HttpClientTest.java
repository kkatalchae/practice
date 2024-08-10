package com.example.example.http.client;

import com.example.example.http.client.rest_template.ResponseDto;
import com.example.example.http.client.web_client.WebClientUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HttpClientTest {

    @Autowired
    private WebClientUtil webClientUtil;

    @Test
    void webClientTest() {

        // given


        // when

        ResponseDto responseDto = webClientUtil.get("http://localhost:8080/api/test", ResponseDto.class);

        System.out.println(responseDto.toString());

        // then
    }
}
