package buffetAplicacion.filter;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import buffetAplicacion.services.TokenServices;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author manuel
 * Filtro Servlet que chequea la validez del token JWT.
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "/*")
public class JWTAuthenticationFilter implements Filter {


    private FilterConfig filterConf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConf = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("ingrear al doFilter");
        // El login del  usuarios es publico
        if ("/usuario/auth".equals(req.getRequestURI()) ||
                "/usuario/new".equals(req.getRequestURI()) ||
                "/menu/day".equals(req.getRequestURI()) ||
               "/comida/id".equals(req.getRequestURI()) ||
                HttpMethod.OPTIONS.matches(req.getMethod())) {
            System.out.println("valida el auth o new");
            chain.doFilter(request, response);
            return;
        }

        String token = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null || !TokenServices.validateToken(token)) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        this.filterConf = null;
    }
}