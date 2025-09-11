//package com.practice.core.services;
package com.adobe.aem.tutorial.core.Services.Impl;
import com.adobe.aem.tutorial.core.Services.CartService;
import org.osgi.service.component.annotations.Component;

import java.util.*;

@Component(service = CartServiceImpl.class)
public class CartServiceImpl implements CartService {

    private List<Map<String, Object>> cartItems = new ArrayList<>();

    public CartServiceImpl() {
        // Demo data for testing
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", "101");
        item1.put("name", "Smartphone");
        item1.put("price", 15000);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", "102");
        item2.put("name", "Shoes");
        item2.put("price", 2500);

        cartItems.add(item1);
        cartItems.add(item2);
    }

    public List<Map<String, Object>> getCartItems() {
        return cartItems;
    }

    public int getCartTotal() {
        return cartItems.stream()
                .mapToInt(i -> (int) i.get("price"))
                .sum();
    }

    public void removeItem(String id) {
        cartItems.removeIf(item -> item.get("id").equals(id));
    }
}
