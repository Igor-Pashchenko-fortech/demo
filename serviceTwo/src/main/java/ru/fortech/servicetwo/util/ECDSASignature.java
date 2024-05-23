package ru.fortech.servicetwo.util;

import org.springframework.stereotype.Component;

import java.security.*;

@Component
public class ECDSASignature {
    public static byte[] signData(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature ecdsaSign = Signature.getInstance("SHA256withECDSA");
        ecdsaSign.initSign(privateKey);
        ecdsaSign.update(data);
        return ecdsaSign.sign();
    }
}
