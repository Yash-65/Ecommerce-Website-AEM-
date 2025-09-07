package com.adobe.aem.tutorial.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;

@Model(adaptables = Resource.class)
public class HeaderModel {

    @ValueMapValue
    private String logoHeader;

    public String getLogoHeader() {
        return logoHeader;
    }
}
