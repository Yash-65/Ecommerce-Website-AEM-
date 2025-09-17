package com.adobe.aem.tutorial.core.models;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProductSearchModel {

    @OSGiService
    private EcommerceService ecommerceService;

    @Self
    private SlingHttpServletRequest request;

    private List<Map<String, Object>> results;
    private String query;

    @PostConstruct
    protected void init() {
        query = request.getParameter("q");   // ✅ Now request is injected
        if (query != null && !query.trim().isEmpty()) {
            results = ecommerceService.searchProducts(query.trim());
        } else {
            results = Collections.emptyList();
        }
    }

    public List<Map<String, Object>> getResults() {
        return results;
    }

    public String getQuery() {
        return query;
    }
}
