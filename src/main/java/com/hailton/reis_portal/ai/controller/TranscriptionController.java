package com.hailton.reis_portal.ai.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.hailton.reis_portal.ai.service.TranscriptionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;



@RestController
@RequestMapping("/ai/transcriptions")
public class TranscriptionController {


    private final TranscriptionService transcriptionService;



    public TranscriptionController(
            TranscriptionService transcriptionService) {

        this.transcriptionService = transcriptionService;
    }




    @PostMapping(
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @Operation(
        summary = "Transcrever arquivo de áudio",
        description = "Envia um arquivo de áudio para transcrição utilizando OpenAI"
    )
    public ResponseEntity<String> transcrever(

            @Parameter(
                description = "Arquivo de áudio para transcrição",
                content = @Content(
                    mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                    schema = @Schema(
                        type = "string",
                        format = "binary"
                    )
                )
            )
            @RequestParam("arquivo") MultipartFile arquivo) {



        String texto =
                transcriptionService.transcrever(arquivo);



        return ResponseEntity.ok(texto);

    }


}