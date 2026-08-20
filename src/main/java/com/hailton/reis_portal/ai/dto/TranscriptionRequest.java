package com.hailton.reis_portal.ai.dto;

import org.springframework.web.multipart.MultipartFile;

public class TranscriptionRequest {


    private MultipartFile arquivo;


    public MultipartFile getArquivo() {
        return arquivo;
    }


    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }

}