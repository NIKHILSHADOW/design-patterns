# ADAPTER

- [Home](../../../../../../README.md)

## Contents

- [ADAPTER](#adapter)
  - [Contents](#contents)
    - [Steps](#steps)
    - [Code](#code)

**Convert the interface of a class into another interface clients expect.
Adapter lets classes work together that couldn't otherwise because of incompat
ible interfaces.**

Let's take example of payment providers

we should use different payment providers in different conditions.

We should build classes in a way they are loosely coupled and high cohesive.

For suppose we have different payment providers like razorpay, paypal, stripe, payu.

Our code should be compatible to all types, but we shouldn't repeat code(avoid code duplication).
so we comeup with adapter design pattern

### Steps

1. Create a common interface or abstract class with methods which all external api's have
2. create concrete classes.

### Code

```
// Step -1 create interface

public interface PaymentProviderInterface {

    public String getLink();

    public String makePayment();

    public PaymentStatus getStatus(String paymentId);

}


// Step -2 implement concrete classes

public class PayUPPI implements PaymentProviderInterface {

    PayUApi api = new PayUApi();

    @Override
    public String getLink() {
        return api.link();
    }

    @Override
    public String makePayment() {
        return api.pay();
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



```
