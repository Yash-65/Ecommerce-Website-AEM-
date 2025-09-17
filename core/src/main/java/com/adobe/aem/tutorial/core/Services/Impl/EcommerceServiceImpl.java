package com.adobe.aem.tutorial.core.Services.Impl;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import org.osgi.service.component.annotations.Component;

import java.util.*;

@Component(service = EcommerceService.class, immediate = true)
public class EcommerceServiceImpl implements EcommerceService {

    private final List<Map<String, Object>> products = new ArrayList<>();

    public EcommerceServiceImpl() {
        // Sample Products
        products.add(createProduct("Smartphone", 15000, 0));
        products.add(createProduct("Shoes", 2500, 0));
        products.add(createProduct("Headphones", 2000, 0));
    }

    private Map<String, Object> createProduct(String name, int price, int qty) {
        Map<String, Object> product = new HashMap<>();
        product.put("name", name);
        product.put("price", price);
        product.put("quantity", qty);
        return product;
    }

    @Override
    public List<Map<String, Object>> getAllProducts() {
        return products;
    }

    @Override
    public List<Map<String, Object>> searchProducts(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return products;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> product : products) {
            if (product.get("name").toString().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void addProductQuantity(String productName) {
//        for (Map<String, Object> product : products) {
//            if (product.get("name").equals(productName)) {
//                int qty = (int) product.get("quantity");
//                product.put("quantity", qty + 1);
//                break;
//            }
//        }
        products.stream()
                .filter(p -> ((String) p.get("name")).equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(p -> p.put("quantity", (int) p.get("quantity") + 1));
    }

    @Override
    public void removeProductQuantity(String productName) {
        products.stream()
                .filter(p -> p.get("name").toString().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(p -> {
                    int qty = (int) p.get("quantity");
                    if (qty > 1) {
                        p.put("quantity", qty - 1);
                    } else {
                        p.put("quantity", 0); // remove from cart
                    }
                });
    }

    @Override
    public List<Map<String, Object>> getCartItems() {
        List<Map<String, Object>> cart = new ArrayList<>();
        for (Map<String, Object> product : products) {
            int qty = (int) product.get("quantity");
            if (qty > 0) {
                cart.add(product);
            }
        }
        return cart;
//        return products.stream()
//                .filter(p -> (int) p.get("quantity") > 0)
//                .toList();
    }

    @Override
    public int getCartTotal() {
        return getCartItems().stream()
                .mapToInt(item -> (int) item.get("price") * (int) item.get("quantity"))
                .sum();
    }
}
