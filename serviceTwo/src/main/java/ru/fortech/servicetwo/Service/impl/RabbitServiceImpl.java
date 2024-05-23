package ru.fortech.servicetwo.Service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.fortech.servicetwo.Service.RabbitService;
import ru.fortech.servicetwo.Service.SignatureService;
import ru.fortech.servicetwo.Service.dto.SignatureResponseDto;
import ru.fortech.servicetwo.config.MQConfiguration;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;


@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final SignatureService signatureService;

    @Override
    @RabbitListener(queues = MQConfiguration.RECEIVE_QUEUE)
    public SignatureResponseDto listen(byte[] message) {
        try {
            return signatureService.signData(message);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
