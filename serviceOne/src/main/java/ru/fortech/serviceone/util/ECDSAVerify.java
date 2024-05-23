package ru.fortech.serviceone.util;

import org.springframework.stereotype.Component;

import java.security.*;

@Component
public class ECDSAVerify {

    public static boolean verifySignature(byte[] data, byte[] signature, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA");
        ecdsaVerify.initVerify(publicKey);
        ecdsaVerify.update(data);
        return ecdsaVerify.verify(signature);
    }
}
