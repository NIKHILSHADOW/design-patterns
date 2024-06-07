package com.example.adapter.payments.external.payu;

public class PayUApi {

    public String link() {
        return "payu-link";
    }

    public String pay(String name, String email) {
        return "payu-id";
    }

    public PayUStatus getStatus(String id) {
        return PayUStatus.OK;
    }
}
