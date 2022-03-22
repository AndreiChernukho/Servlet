import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/cars")
public class TestFilter implements Filter {
    private static final String SPECIAL_PARAMETER_NAME = "isValid";
    private static final String ALLOWED_REQUEST_TYPE = "GET";
    private static final String ERROR_PAGE_PATH = "/main/webapp/WEB-INF/error.jsp";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        boolean isValid = Boolean.getBoolean(request.getParameter(SPECIAL_PARAMETER_NAME));
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (isValid || httpServletRequest.getMethod().equals(ALLOWED_REQUEST_TYPE)) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
