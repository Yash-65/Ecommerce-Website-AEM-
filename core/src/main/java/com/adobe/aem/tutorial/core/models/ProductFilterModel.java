//package com.practice.core.models;
package com.adobe.aem.tutorial.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductFilterModel {

    @ValueMapValue
    private String title;

    public String getTitle() {
        return title != null ? title : "Filters";
    }
}
