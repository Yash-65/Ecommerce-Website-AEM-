//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
//import com.practice.core.services.CheckoutService;
import com.adobe.aem.tutorial.core.services.CheckoutService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CheckoutModel {

    @OSGiService
    private CheckoutService checkoutService;

    public int getTotal() {
        return checkoutService.getTotalAmount();
    }
}
