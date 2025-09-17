
//import com.adobe.aem.tutorial.core.Services.EcommerceService;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.servlets.SlingAllMethodsServlet;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.servlet.Servlet;
//import java.io.IOException;
//
//@Component(service = Servlet.class,
//        property = {
//                "sling.servlet.paths=/bin/addtocart",
//                "sling.servlet.methods=GET"
//        })
//public class AddToCartServlet extends SlingAllMethodsServlet {
//
//    @Reference
//    private EcommerceService ecommerceService;
//
//    @Override
//    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
//        String productName = request.getParameter("name");
//        if (productName != null) {
//            ecommerceService.addProductQuantity(productName);
//            response.getWriter().write("Added " + productName + " to cart");
//        } else {
//            response.getWriter().write("Product name missing");
//        }
//    }
//}

package com.adobe.aem.tutorial.core.servlets;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Map;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/addtocart",
                "sling.servlet.methods=GET"
        })
public class AddToCartServlet extends SlingAllMethodsServlet {

    @Reference
    private EcommerceService ecommerceService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String productName = request.getParameter("name");
        if (productName != null) {
            Map<String, Object> match = ecommerceService.getAllProducts().stream()
                    .filter(p -> ((String) p.get("name")).equalsIgnoreCase(productName))
                    .findFirst()
                    .orElse(null);

            if (match != null) {
                ecommerceService.addProductQuantity(productName);
                response.getWriter().write("Added " + productName + " to cart");
            } else {
                response.getWriter().write("No such product found in system: " + productName);
            }
        } else {
            response.getWriter().write("Product name missing");
        }
    }
}
