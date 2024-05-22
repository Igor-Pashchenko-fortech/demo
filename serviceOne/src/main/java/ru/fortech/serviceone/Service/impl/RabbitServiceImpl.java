package ru.fortech.serviceone.Service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.fortech.serviceone.Service.RabbitService;
import ru.fortech.serviceone.Service.dto.SignatureResponseDto;
import ru.fortech.serviceone.config.MQConfiguration;
import ru.fortech.serviceone.util.ByteArrayGenerator;
import ru.fortech.serviceone.util.ECDSAVerify;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;

    public boolean verifySignature(SignatureResponseDto message) {
        try {
            byte[] data = message.getData();
            byte[] signature = message.getSignature();
            byte[] publicKeyBytes = message.getPublicKeyBytes();

            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            return ECDSAVerify.verifySignature(data, signature, publicKey);
        } catch (Exception e) {
            log.info("result: false and error: {}", (Object) e.getStackTrace());
            return false;
        }
    }

    @Override
    public SignatureResponseDto sendMessage() {
        return rabbitTemplate.convertSendAndReceiveAsType(
                MQConfiguration.RPC_EXCHANGE, MQConfiguration.ROUTING_KEY, ByteArrayGenerator.getRandomBytes(),
                new ParameterizedTypeReference<>() {
                });
    }


}
