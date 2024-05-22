package ru.fortech.servicetwo.Service;


import ru.fortech.servicetwo.Service.dto.SignatureResponseDto;

public interface RabbitService {
    SignatureResponseDto listen(byte[] message);
}
