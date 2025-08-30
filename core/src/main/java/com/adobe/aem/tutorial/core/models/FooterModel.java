//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import com.adobe.cq.sightly.WCMUsePojo;
import java.util.List;
import java.util.ArrayList;
import org.apache.sling.api.resource.ValueMap;

public class FooterModel extends WCMUsePojo {

    private String footerText;
    private List<String> socialLinks;

    @Override
    public void activate() throws Exception {
        ValueMap properties = getProperties();
        footerText = properties.get("footerText", "");
        socialLinks = properties.get("socialLinks", new ArrayList<String>());
    }

    public String getFooterText() {
        return footerText;
    }

    public List<String> getSocialLinks() {
        return socialLinks;
    }
}
