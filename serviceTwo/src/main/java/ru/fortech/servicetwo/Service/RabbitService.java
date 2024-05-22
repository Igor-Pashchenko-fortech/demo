package ru.fortech.servicetwo.Service;


import ru.fortech.servicetwo.Service.dto.ResponseDto;

public interface RabbitService {
    ResponseDto listen(byte[] message);
}
