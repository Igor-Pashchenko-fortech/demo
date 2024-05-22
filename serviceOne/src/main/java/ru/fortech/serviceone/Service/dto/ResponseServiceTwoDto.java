package ru.fortech.serviceone.Service.dto;

import lombok.Data;


@Data
public class ResponseServiceTwoDto {
    private byte[] data;
    private byte[] signature;
    private byte[] publicKeyBytes;
}
