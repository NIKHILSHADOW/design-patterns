package com.example.adapter.payments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.adapter.payments.internal.PayUPPI;
import com.example.adapter.payments.internal.PaymentRequest;
import com.example.adapter.payments.internal.PaymentStatus;
import com.example.adapter.payments.internal.RazorPayPPI;

public class PaymentTest {

    private RazorPayPPI razorPayPPI;
    private PayUPPI payUPPI;
    private PaymentRequest paymentRequest;

    @Before
    public void setUp() {
        payUPPI = new PayUPPI();
        razorPayPPI = new RazorPayPPI();
        paymentRequest = PaymentRequest
                .builder()
                .name("akash")
                .email("akash@gmail.com")
                .phone("28728820929")
                .build();

    }

    @Test
    public void instanceCreation() {
        Assert.assertNotNull(payUPPI);
        Assert.assertTrue("it should be payU", payUPPI instanceof PayUPPI);

        Assert.assertNotNull(razorPayPPI);
        Assert.assertTrue("it should be razorPAy", razorPayPPI instanceof RazorPayPPI);

    }

    @Test
    public void razorPayTest() {
        String link = razorPayPPI.getLink();
        Assert.assertEquals("razorpayLink", link);

        String paymentId = razorPayPPI.makePayment(paymentRequest);
        Assert.assertEquals("razorpay-id", paymentId);

        PaymentStatus status = razorPayPPI.getStatus(paymentId);
        Assert.assertEquals(PaymentStatus.SUCCESS, status);

    }

    @Test
    public void payUTest() {
        String link = payUPPI.getLink();
        Assert.assertEquals("payu-link", link);

        String paymentID = payUPPI.makePayment(paymentRequest);
        Assert.assertEquals("payu-id", paymentID);

        PaymentStatus paymentStatus = payUPPI.getStatus(paymentID);
        Assert.assertEquals(PaymentStatus.SUCCESS, paymentStatus);
    }
}
