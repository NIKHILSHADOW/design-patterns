package com.example.adapter.payments.internal;

import com.example.adapter.payments.external.payu.PayUApi;
import com.example.adapter.payments.external.payu.PayUStatus;

public class PayUPPI implements PaymentProviderInterface {

    PayUApi api = new PayUApi();

    @Override
    public String getLink() {
        return api.link();
    }

    @Override
    public String makePayment(PaymentRequest paymentRequest) {
        return api.pay(paymentRequest.getName(), paymentRequest.getEmail());
    }

    @Override
    public PaymentStatus getStatus(String paymentId) {
        return toLink(api.getStatus(paymentId));
    }

    private PaymentStatus toLink(PayUStatus status) {

        if (status == PayUStatus.OK) {
            return PaymentStatus.SUCCESS;
        }

        return PaymentStatus.FAIL;
    }

}
