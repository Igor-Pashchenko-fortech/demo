package ru.fortech.serviceone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fortech.serviceone.Service.RabbitService;
import ru.fortech.serviceone.Service.dto.ResponseDto;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/send")
public class Controller {
    private final RabbitService rabbitService;
    private final static String SUCCESS_MESSAGE = "подпись корректна";
    private final static String FAIL_MESSAGE = "подпись не корректна";

    @GetMapping
    public ResponseEntity<?> pushRabbit() {
        if (rabbitService.verifySignature(rabbitService.sendMessage())){
            return ResponseEntity.ok(ResponseDto.builder().message(SUCCESS_MESSAGE).build());
        }
        return ResponseEntity.ok(ResponseDto.builder().message(FAIL_MESSAGE).build());
    }
}
