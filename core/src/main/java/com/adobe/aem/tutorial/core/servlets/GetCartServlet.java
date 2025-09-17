package com.adobe.aem.tutorial.core.servlets;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/getcart",
                "sling.servlet.methods=GET"
        }
)
public class GetCartServlet extends SlingAllMethodsServlet {

    @Reference
    private EcommerceService ecommerceService;

    private final Gson gson = new Gson();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        Map<String, Object> cartData = new HashMap<>();
        cartData.put("items", ecommerceService.getCartItems());
        cartData.put("total", ecommerceService.getCartTotal());

        response.getWriter().write(gson.toJson(cartData));
    }
}
