package ru.fortech.serviceone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fortech.serviceone.Service.RabbitService;
import ru.fortech.serviceone.Service.dto.SignatureStatusResponseDto;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/send")
public class SendController {
    private final RabbitService rabbitService;
    private final static String SUCCESS_MESSAGE = "подпись корректна";
    private final static String FAIL_MESSAGE = "подпись не корректна";

    @GetMapping
    public ResponseEntity<?> pushRabbit() {
        if (rabbitService.verifySignature(rabbitService.sendMessage())){
            return ResponseEntity.ok(SignatureStatusResponseDto.builder().message(SUCCESS_MESSAGE).build());
        }
        return ResponseEntity.ok(SignatureStatusResponseDto.builder().message(FAIL_MESSAGE).build());
    }
}
