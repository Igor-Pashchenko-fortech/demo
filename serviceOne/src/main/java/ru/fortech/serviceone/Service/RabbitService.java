package ru.fortech.serviceone.Service;

import ru.fortech.serviceone.Service.dto.ResponseServiceTwoDto;

public interface RabbitService {
    ResponseServiceTwoDto sendMessage();

    boolean verifySignature(ResponseServiceTwoDto message);
}
