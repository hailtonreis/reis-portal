package com.hailton.reis_portal.ai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hailton.reis_portal.ai.client.OpenAiClient;

@Service
public class TranscriptionService {


    private final OpenAiClient openAiClient;
    
    


    public TranscriptionService(OpenAiClient openAiClient) {
        this.openAiClient = openAiClient;
    }


    public String transcrever(MultipartFile arquivo) {

        validarArquivo(arquivo);

        return openAiClient.transcreverAudio(arquivo);
    }

    private static final long TAMANHO_MAXIMO_AUDIO = 300 * 1024 * 1024;
    
    private void validarArquivo(MultipartFile arquivo) {

        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException(
                "Arquivo de áudio obrigatório."
            );
        }
        
        if (arquivo.getSize() > TAMANHO_MAXIMO_AUDIO) {
            throw new IllegalArgumentException(
                "Arquivo de áudio excede o limite permitido de 300MB."
            );
        }
        
        String contentType = arquivo.getContentType();

        if (contentType == null ||
            !(contentType.equals("audio/mpeg")
            || contentType.equals("audio/mp4")
            || contentType.equals("audio/wav")
            || contentType.equals("audio/x-wav")
            || contentType.equals("video/mp4"))) {

            throw new IllegalArgumentException(
                "Formato de áudio não suportado."
            );
        }

    }

}