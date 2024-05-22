package ru.fortech.serviceone.util;

import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.security.Signature;

@Component
public class ECDSAVerify {

    public static boolean verifySignature(byte[] data, byte[] signature, PublicKey publicKey) throws Exception {
        Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA");
        ecdsaVerify.initVerify(publicKey);
        ecdsaVerify.update(data);
        return ecdsaVerify.verify(signature);
    }
}
