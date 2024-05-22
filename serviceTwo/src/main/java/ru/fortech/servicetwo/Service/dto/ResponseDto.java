package ru.fortech.servicetwo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private byte[] data;
    private byte[] signature;
    private byte[] publicKeyBytes;
}
