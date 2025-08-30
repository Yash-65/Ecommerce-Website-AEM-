//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.resource.Resource;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HeroModel extends WCMUsePojo {

    private List<Map<String, String>> slides;

    @Override
    public void activate() throws Exception {
        slides = new ArrayList<>();
        Resource slidesResource = getResource().getChild("slides");
        if (slidesResource != null) {
            for (Resource slide : slidesResource.getChildren()) {
                ValueMap vm = slide.getValueMap();
                Map<String, String> slideData = new HashMap<>();
                slideData.put("image", vm.get("image", ""));
                slideData.put("title", vm.get("title", ""));
                slideData.put("description", vm.get("description", ""));
                slideData.put("ctaText", vm.get("ctaText", ""));
                slideData.put("ctaLink", vm.get("ctaLink", ""));
                slides.add(slideData);
            }
        }
    }

    public List<Map<String, String>> getSlides() {
        return slides;
    }
}
