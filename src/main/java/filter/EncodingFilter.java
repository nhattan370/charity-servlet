package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        // Nếu là file tĩnh (.css, .js, .png...) thì bỏ qua setContentType
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") 
            || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".gif")) {
            chain.doFilter(request, response);
            return;
        }

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        chain.doFilter(request, response);
    }
}


