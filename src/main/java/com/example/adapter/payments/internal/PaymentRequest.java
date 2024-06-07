package com.example.adapter.payments.internal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentRequest {
    private String name;
    private String email;
    private String phone;
}
