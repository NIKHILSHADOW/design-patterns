package com.example.adapter.payments.internal;

public interface PaymentProviderInterface {

    public String getLink();

    public String makePayment(PaymentRequest paymentRequest);

    public PaymentStatus getStatus(String paymentId);

}
