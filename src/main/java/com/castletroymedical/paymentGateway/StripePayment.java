package com.castletroymedical.paymentGateway;

public class StripePayment implements CardStrategy {
    public void pay(double amount) {
      System.out.println("Paid through Stripe");
    }   
}