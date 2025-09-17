package com.adobe.aem.tutorial.core.Services;

import java.util.List;
import java.util.Map;

public interface EcommerceService {
    List<Map<String, Object>> getAllProducts();
    List<Map<String, Object>> searchProducts(String keyword);

    void addProductQuantity(String productName);
    void removeProductQuantity(String productName);

    List<Map<String, Object>> getCartItems();
    int getCartTotal();
}
