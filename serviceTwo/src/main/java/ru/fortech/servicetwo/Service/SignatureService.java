package ru.fortech.servicetwo.Service;

import ru.fortech.servicetwo.Service.dto.SignatureResponseDto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;


public interface SignatureService {
    SignatureResponseDto signData(byte[] data) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException;
}
