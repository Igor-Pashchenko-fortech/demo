package ru.fortech.serviceone.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ByteArrayGenerator {
    public static byte[] getRandomBytes() {
        int arraySize = 200 * 1024; // 200 килобайт
        byte[] byteArray = new byte[arraySize];
        Random random = new Random();
        random.nextBytes(byteArray);
        return byteArray;
    }
}
