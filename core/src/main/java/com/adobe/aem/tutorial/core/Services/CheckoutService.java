package com.adobe.aem.tutorial.core.Services;

public interface CheckoutService {
    public boolean placeOrder(String name, String address, String phone, String payment);
    public int getTotalAmount();
}
