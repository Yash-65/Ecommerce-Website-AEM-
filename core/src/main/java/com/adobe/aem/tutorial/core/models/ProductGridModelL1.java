package com.adobe.aem.tutorial.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductGridModelL1 {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String price;

    @ValueMapValue
    private String ctaText;

    public String getImage() { return image; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public String getCtaText() { return ctaText; }

}
