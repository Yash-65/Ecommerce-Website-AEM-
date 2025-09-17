//package com.adobe.aem.tutorial.core.models;
//
//import com.adobe.aem.tutorial.core.Services.EcommerceService;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.OSGiService;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
//@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class CartModel {
//
//    @OSGiService
//    private EcommerceService ecommerceService;
//
//    private List<Map<String, Object>> cartItems;
//    private double cartTotal;
//
//    @ValueMapValue
//    private String title;
//
//    @ValueMapValue
//    private String checkoutPage; // Pathfield set by author
//
//    @PostConstruct
//    protected void init() {
//        cartItems = new ArrayList<>();
//        cartTotal = 0.0;
//
//        if (ecommerceService != null) {
//            for (Map<String, Object> product : ecommerceService.getCartItems()) {
//                int price = (int) product.get("price");
//                int qty = (int) product.get("quantity");
//                int subtotal = price * qty;
//
//                Map<String, Object> itemWithSubtotal = new HashMap<>(product);
//                itemWithSubtotal.put("subtotal", subtotal);
//
//                cartItems.add(itemWithSubtotal);
//                cartTotal += subtotal;
//            }
//        }
//    }
//
//    public List<Map<String, Object>> getCartItems() {
//        return cartItems;
//    }
//
//    public double getCartTotal() {
//        return cartTotal;
//    }
//
//    public String getTitle() {
//        return title != null ? title : "Your Shopping Cart";
//    }
//
//    public String getCheckoutPage() {
//        return checkoutPage != null ? checkoutPage : "#";
//    }
//}
//

package com.adobe.aem.tutorial.core.models;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = {CartModel.class, ComponentExporter.class},
        resourceType = "practice/components/cart",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CartModel implements ComponentExporter {

    @OSGiService
    private EcommerceService ecommerceService;

    @Self
    private SlingHttpServletRequest request;

    private List<Map<String, Object>> cartItems;
    private double cartTotal;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String checkoutPage; // Pathfield set by author

    @PostConstruct
    protected void init() {
        cartItems = new ArrayList<>();
        cartTotal = 0.0;

        if (ecommerceService != null) {

            String removeProduct = request.getParameter("remove");
            if (removeProduct != null && !removeProduct.isEmpty()) {
                ecommerceService.removeProductQuantity(removeProduct);
            }

            for (Map<String, Object> product : ecommerceService.getCartItems()) {
                int price = (int) product.get("price");
                int qty = (int) product.get("quantity");
                int subtotal = price * qty;

                Map<String, Object> itemWithSubtotal = new HashMap<>(product);
                itemWithSubtotal.put("subtotal", subtotal);

                cartItems.add(itemWithSubtotal);
                cartTotal += subtotal;
            }
        }
    }

    public List<Map<String, Object>> getCartItems() {
        return cartItems;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public String getTitle() {
        return title != null ? title : "Your Shopping Cart";
    }

    public String getCheckoutPage() {
        return checkoutPage != null ? checkoutPage : "#";
    }

    @Override
    public String getExportedType() {
        return "practice/components/cart";
    }
}

