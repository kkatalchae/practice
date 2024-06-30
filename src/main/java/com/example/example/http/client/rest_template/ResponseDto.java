package com.example.example.http.client.rest_template;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ResponseDto {

    private String url;
    private String title;
    private String description;
    private Map<String, Object> body;

    @Override
    public String toString() {
        return String.format("""
                        RestTemplateResponse
                        url : %s
                        title : %s
                        description : %s
                        """,
                this.url, this.title, this.description
        );
    }
}
