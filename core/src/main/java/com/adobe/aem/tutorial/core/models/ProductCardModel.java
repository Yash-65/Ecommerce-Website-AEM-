//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.ValueMap;

public class ProductCardModel extends WCMUsePojo {

    private String image;
    private String title;
    private String description;
    private String price;
    private String ctaText;

    @Override
    public void activate() throws Exception {
        ValueMap vm = getResource().getValueMap();
        image = vm.get("image", "");
        title = vm.get("title", "");
        description = vm.get("description", "");
        price = vm.get("price", "");
        ctaText = vm.get("ctaText", "Add to Cart");
    }

    public String getImage() { return image; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public String getCtaText() { return ctaText; }
}
