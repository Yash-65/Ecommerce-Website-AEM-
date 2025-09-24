package com.adobe.aem.tutorial.core.servlets;

import com.adobe.aem.tutorial.core.Services.EcommerceService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/removefromcart",
                "sling.servlet.methods=GET",
                "sling.servlet.methods=POST"
        })
public class RemoveFromCartServlet extends SlingAllMethodsServlet {

    @Reference
    private EcommerceService ecommerceService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            response.getWriter().write("{\"success\":false,\"message\":\"Missing product name\"}");
            return;
        }

        ecommerceService.removeProductQuantity(name);

        // Return updated cart JSON
        writeCartJson(response, ecommerceService.getCartItems(), ecommerceService.getCartTotal());
    }

    private void writeCartJson(SlingHttpServletResponse response, List<Map<String,Object>> items, int total) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"success\":true,\"items\":[");
        for (int i=0;i<items.size();i++) {
            Map<String,Object> it = items.get(i);
            String nm = safeString(it.get("name"));
            Number price = (Number) it.get("price");
            Number qty = (Number) it.get("quantity");
            int subtotal = price.intValue() * qty.intValue();
            sb.append("{");
            sb.append("\"name\":\"").append(escape(nm)).append("\",");
            sb.append("\"price\":").append(price).append(",");
            sb.append("\"quantity\":").append(qty).append(",");
            sb.append("\"subtotal\":").append(subtotal);
            sb.append("}");
            if (i < items.size()-1) sb.append(",");
        }
        sb.append("],\"total\":").append(total).append("}");
        response.getWriter().write(sb.toString());
    }

    private String safeString(Object o) { return o==null? "": o.toString(); }
    private String escape(String s) {
        return s.replace("\\","\\\\").replace("\"","\\\"").replace("\n","\\n").replace("\r","\\r");
    }
}
