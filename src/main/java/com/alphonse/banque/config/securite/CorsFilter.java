package com.alphonse.banque.config.securite;


import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {
/**Declaration du port front end
 */
    @Value("${banque.serveur-app}")
    private String appCorsServer;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Set Access-Control-Allow headers
        httpResponse.setHeader("Access-Control-Allow-Origin", appCorsServer);
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers", "authorization, content-type");

        // Continue the filter chain
        chain.doFilter(request, response);
    }


}