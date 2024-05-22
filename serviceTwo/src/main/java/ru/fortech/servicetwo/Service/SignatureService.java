package ru.fortech.servicetwo.Service;

import ru.fortech.servicetwo.Service.dto.ResponseDto;


public interface SignatureService {
    ResponseDto signData(byte[] data) throws Exception;
}
