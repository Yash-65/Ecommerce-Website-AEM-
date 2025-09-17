//package com.adobe.aem.tutorial.core.models;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ValueMap;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ChildResource;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class CarouselModel {
//
//    @ChildResource(name = "fieldCarousel")
//    private List<CarouselModelL1> slides;
//
//
//    public List<CarouselModelL1> getSlides() {
//        return slides;
//    }
//}

package com.adobe.aem.tutorial.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModel {

    @ChildResource(name = "fieldCarousel")
    private List<CarouselModelL1> slides;


    public List<CarouselModelL1> getSlides() {
        return slides;
    }
}