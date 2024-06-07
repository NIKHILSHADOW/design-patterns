package com.example.adapter.payments.external.razorpay;

public class RazorpayApi {

    public String getLink() {
        return "razorpayLink";
    }

    public String makePayment() {
        return "razorpay-id";
    }

    public RazorpayStatus getStatus(String id) {
        return RazorpayStatus.SUCCESS;
    }
}
