//package com.adobe.aem.tutorial.core.models;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class CarouselModelL1 {
//
//    @ValueMapValue
//    private String image;
//
//    @ValueMapValue
//    private String link;
//
//    @ValueMapValue
//    private String title;
//
//    public String getImage() {
//        return image;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}

package com.adobe.aem.tutorial.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModelL1 {

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String title;

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}