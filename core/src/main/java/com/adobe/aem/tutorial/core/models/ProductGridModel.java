//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import com.adobe.cq.sightly.WCMUsePojo;
import com.google.gson.Gson;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

public class ProductGridModel extends WCMUsePojo {

    private List<ProductItem> products;

    @Override
    public void activate() throws Exception {
        products = new ArrayList<>();
        String[] items = getProperties().get("products", String[].class);

        if (items != null) {
            Gson gson = new Gson();
            for (String item : items) {
                ProductItem product = gson.fromJson(item, ProductItem.class);
                products.add(product);
            }
        }
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public static class ProductItem {
        private String image;
        private String title;
        private String description;
        private String price;
        private String ctaText;

        public String getImage() { return image; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getPrice() { return price; }
        public String getCtaText() { return ctaText; }
    }
}
