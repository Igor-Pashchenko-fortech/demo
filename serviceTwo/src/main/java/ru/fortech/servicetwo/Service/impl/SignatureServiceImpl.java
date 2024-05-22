package ru.fortech.servicetwo.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fortech.servicetwo.Service.SignatureService;
import ru.fortech.servicetwo.Service.dto.SignatureResponseDto;
import ru.fortech.servicetwo.util.ECDSAKeyPairGenerator;
import ru.fortech.servicetwo.util.ECDSASignature;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

@Service
@RequiredArgsConstructor
public class SignatureServiceImpl implements SignatureService {

    @Override
    public SignatureResponseDto signData(byte[] data) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        KeyPair keyPair = ECDSAKeyPairGenerator.generateKeyPair();
        return SignatureResponseDto.builder()
                .data(data)
                .signature(ECDSASignature.signData(data, keyPair.getPrivate()))
                .publicKeyBytes(keyPair.getPublic().getEncoded())
                .build();
    }
}
