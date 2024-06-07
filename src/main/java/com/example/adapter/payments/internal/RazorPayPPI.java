package com.example.adapter.payments.internal;

import com.example.adapter.payments.external.razorpay.RazorpayApi;
import com.example.adapter.payments.external.razorpay.RazorpayStatus;

public class RazorPayPPI implements PaymentProviderInterface {

    private RazorpayApi api = new RazorpayApi();

    @Override
    public String getLink() {
        return api.getLink();
    }

    @Override
    public String makePayment() {
        return api.makePayment();
    }

    @Override
    public PaymentStatus getStatus(String paymentId) {
        return toPaymentStatus(api.getStatus(paymentId));
    }

    private PaymentStatus toPaymentStatus(RazorpayStatus status) {

        if (status == RazorpayStatus.SUCCESS) {
            return PaymentStatus.SUCCESS;
        }

        return PaymentStatus.FAIL;
    }

}
