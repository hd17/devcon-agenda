package com.senacor.hd17.devcon;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Andri Bremm
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myStupidAllowAllCorsFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

    public Filter myStupidAllowAllCorsFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.addHeader("Access-Control-Allow-Credentials", "true");
                response.addHeader("Access-Control-Allow-Methods", "ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, " +
                        "OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, UNLOCK, UPDATE, VERSION-CONTROL");

                response.addHeader("Access-Control-Allow-Headers", "Overwrite, Destination, Content-Type, Depth, User-Agent, Translate, Range, Content-Range, " +
                        "Timeout, X-File-Size, X-Requested-With, If-Modified-Since, X-File-Name, Cache-Control, Location, Lock-Token, If");

                response.addHeader("Access-Control-Expose-Headers", "DAV, content-length, Allow");

                filterChain.doFilter(request, response);
            }
        };
    }

}
