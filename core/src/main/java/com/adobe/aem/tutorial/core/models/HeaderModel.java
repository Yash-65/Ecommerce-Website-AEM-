package com.adobe.aem.tutorial.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = org.apache.sling.api.resource.Resource.class)
public class HeaderModel {

    @ValueMapValue
    private String logo;

    public String getLogo() {
        return logo;
    }
}
