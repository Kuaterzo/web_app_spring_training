package fr.lernejo;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter{

    private String uniqueKey;

    public ApplicationIdentifierFilter(){

        this.uniqueKey = UUID.randomUUID().toString();

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.setHeader("Instance-ID",this.uniqueKey);
        filterChain.doFilter(servletRequest,httpServletResponse);
    }
}
