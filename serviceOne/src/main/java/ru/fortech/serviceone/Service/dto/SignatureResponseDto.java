package ru.fortech.serviceone.Service.dto;

import lombok.Data;


@Data
public class SignatureResponseDto {
    private byte[] data;
    private byte[] signature;
    private byte[] publicKeyBytes;
}
