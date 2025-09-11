//package com.practice.core.services;
package com.adobe.aem.tutorial.core.Services.Impl;

import com.adobe.aem.tutorial.core.Services.CheckoutService;
import org.osgi.service.component.annotations.Component;

@Component(service = CheckoutService.class)
public class CheckoutServiceImpl implements CheckoutService{

    public int getTotalAmount() {
        return 17500;
    }

    public boolean placeOrder(String name, String address, String phone, String payment) {
        // Save order details to DB or external system
        System.out.println("Order placed by: " + name + " | Payment: " + payment);
        return true;
    }
}
