//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarouselModel extends WCMUsePojo {

    private List<Map<String, String>> slides;

    @Override
    public void activate() throws Exception {
        slides = new ArrayList<>();
        Object[] slideItems = getProperties().get("slides", Object[].class);

        if (slideItems != null) {
            for (Object slideObj : slideItems) {
                if (slideObj instanceof ValueMap) {
                    ValueMap slide = (ValueMap) slideObj;
                    slides.add(Map.of(
                            "image", slide.get("image", ""),
                            "title", slide.get("title", ""),
                            "link", slide.get("link", "")
                    ));
                }
            }
        }
    }

    public List<Map<String, String>> getSlides() {
        return slides;
    }
}
