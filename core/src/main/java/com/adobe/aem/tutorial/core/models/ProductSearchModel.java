//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductSearchModel {

    @ValueMapValue
    private String placeholderText;

    public String getPlaceholderText() {
        return placeholderText != null ? placeholderText : "Search for products...";
    }
}
