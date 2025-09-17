//package com.adobe.aem.tutorial.core.models;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ChildResource;
//
//import java.util.List;
//
//@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class ProductGridModel {
//
//    @ChildResource(name = "productGridField")
//    private List<ProductGridModelL1> products;
//
//    public List<ProductGridModelL1> getProducts() {
//        return products;
//    }
//
//}
package com.adobe.aem.tutorial.core.models;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.List;
import java.util.Map;

@Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductGridModel {

    @ChildResource(name = "productGridField")
    private List<ProductGridModelL1> products;

    public List<ProductGridModelL1> getProducts() {
        return products;
    }

    @OSGiService
    private EcommerceService ecommerceService;


//    public List<Map<String, Object>> getProducts() {
//        return ecommerceService.getAllProducts();
//    }

    public void addProduct(String productName) {
        ecommerceService.addProductQuantity(productName);
    }
}
