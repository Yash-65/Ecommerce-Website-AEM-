//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;

//import com.practice.core.services.CartService;
import com.adobe.aem.tutorial.core.services.CartService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.List;
import java.util.Map;

@Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CartModel {

    @OSGiService
    private CartService cartService;

    public List<Map<String, Object>> getItems() {
        return cartService.getCartItems();
    }

    public int getTotal() {
        return cartService.getCartTotal();
    }
}
