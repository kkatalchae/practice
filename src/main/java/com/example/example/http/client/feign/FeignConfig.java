package com.example.example.http.client.feign;

import com.example.example.constant.CONST;
import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 모든 feign 클라이언트에 대해 공통적으로 적용되어야 하는 설정
@EnableFeignClients(basePackages = CONST.BASE_PACKAGE)
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        /*
        - NONE : HTTP 요청에 대한 로그를 출력하지 않는다 (기본값)
        - BASIC : 요청 메소드와 URL, 응답의 상태코드, 실행 시간만 제공
        - HEADERS : 요청과 응답에 대한 헤더만 제공
        - FULL : 요청과 응답에 대한 headers, body, metadata 에 대한 모든 것을 제공
         */
        return Logger.Level.FULL;
    }
}
