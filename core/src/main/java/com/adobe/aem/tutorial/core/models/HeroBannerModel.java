//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import com.adobe.cq.sightly.WCMUsePojo;

public class HeroBannerModel extends WCMUsePojo {

    private String backgroundImage;
    private String title;
    private String subtitle;
    private String ctaText;
    private String ctaLink;

    @Override
    public void activate() throws Exception {
        backgroundImage = getProperties().get("backgroundImage", String.class);
        title = getProperties().get("title", String.class);
        subtitle = getProperties().get("subtitle", String.class);
        ctaText = getProperties().get("ctaText", String.class);
        ctaLink = getProperties().get("ctaLink", String.class);
    }

    public String getBackgroundImage() { return backgroundImage; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public String getCtaText() { return ctaText; }
    public String getCtaLink() { return ctaLink; }
}
