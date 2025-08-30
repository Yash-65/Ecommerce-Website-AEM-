//package com.practice.core.services;
package com.adobe.aem.tutorial.core.services;

import org.osgi.service.component.annotations.Component;

@Component(service = CheckoutService.class)
public class CheckoutService {

    public int getTotalAmount() {
        // Demo value; later integrate with CartService
        return 17500;
    }

    public boolean placeOrder(String name, String address, String phone, String payment) {
        // Save order details to DB or external system
        System.out.println("Order placed by: " + name + " | Payment: " + payment);
        return true;
    }
}
