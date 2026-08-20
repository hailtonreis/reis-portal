package com.hailton.reis_portal.ai.client;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import com.hailton.reis_portal.ai.config.OpenAiProperties;
import com.hailton.reis_portal.ai.dto.TranscriptionResponse;


@Component
public class OpenAiClient {


    private final RestClient restClient;

    private final OpenAiProperties properties;



    public OpenAiClient(
            RestClient openAiRestClient,
            OpenAiProperties properties) {

        this.restClient = openAiRestClient;
        this.properties = properties;
    }




    public String transcreverAudio(
            MultipartFile arquivo) {


        TranscriptionResponse response =
                restClient.post()
                .uri("/audio/transcriptions")
                .contentType(
                    MediaType.MULTIPART_FORM_DATA
                )
                .body(
                    criarFormulario(arquivo)
                )
                .retrieve()
                .body(TranscriptionResponse.class);



        return response.getText();

    }




    private MultiValueMap<String, Object> criarFormulario(
            MultipartFile arquivo) {


        MultiValueMap<String, Object> body =
                new LinkedMultiValueMap<>();


        body.add(
            "file",
            arquivo.getResource()
        );


        body.add(
            "model",
            properties.getModel()
        );


        return body;
    }

}