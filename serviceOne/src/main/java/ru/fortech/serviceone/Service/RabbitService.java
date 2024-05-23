package ru.fortech.serviceone.Service;

import ru.fortech.serviceone.Service.dto.SignatureResponseDto;

public interface RabbitService {
    SignatureResponseDto sendMessage();

    boolean verifySignature(SignatureResponseDto message);
}
