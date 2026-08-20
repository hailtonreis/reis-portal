package com.hailton.reis_portal.ai.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


@Configuration
@EnableConfigurationProperties(OpenAiProperties.class)
public class OpenAiConfig {


    @Bean
    public RestClient openAiRestClient(
            OpenAiProperties properties) {


        return RestClient.builder()
                .baseUrl(properties.getBaseUrl())
                .defaultHeader(
                    HttpHeaders.AUTHORIZATION,
                    "Bearer " + properties.getApiKey()
                )
                .defaultHeader(
                    HttpHeaders.ACCEPT,
                    MediaType.APPLICATION_JSON_VALUE
                )
                .build();
    }

}