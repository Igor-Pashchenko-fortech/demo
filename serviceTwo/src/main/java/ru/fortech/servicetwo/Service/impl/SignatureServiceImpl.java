package ru.fortech.servicetwo.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fortech.servicetwo.Service.SignatureService;
import ru.fortech.servicetwo.Service.dto.ResponseDto;
import ru.fortech.servicetwo.util.ECDSAKeyPairGenerator;
import ru.fortech.servicetwo.util.ECDSASignature;

import java.security.KeyPair;

@Service
@RequiredArgsConstructor
public class SignatureServiceImpl implements SignatureService {

    @Override
    public ResponseDto signData(byte[] data) throws Exception {
        KeyPair keyPair = ECDSAKeyPairGenerator.generateKeyPair();
        return ResponseDto.builder()
                .data(data)
                .signature(ECDSASignature.signData(data, keyPair.getPrivate()))
                .publicKeyBytes(keyPair.getPublic().getEncoded())
                .build();
    }
}
