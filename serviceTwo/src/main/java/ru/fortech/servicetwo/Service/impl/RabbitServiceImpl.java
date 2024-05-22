package ru.fortech.servicetwo.Service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.fortech.servicetwo.Service.RabbitService;
import ru.fortech.servicetwo.Service.SignatureService;
import ru.fortech.servicetwo.Service.dto.ResponseDto;
import ru.fortech.servicetwo.config.MQConfiguration;


@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final SignatureService signatureService;
    @Override
    @RabbitListener(queues = MQConfiguration.RECEIVE_QUEUE)
    public ResponseDto listen(byte[] message) {
        try {
            return signatureService.signData(message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } throw new RuntimeException();
    }
}
