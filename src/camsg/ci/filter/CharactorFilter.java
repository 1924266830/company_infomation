package camsg.ci.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharactorFilter
 */

public class CharactorFilter implements Filter {



    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;character=UTF-8");
        
        
        chain.doFilter(request, response);
      }



    public void init(FilterConfig filterConfig) throws ServletException {
      //获取初始化参数

    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

}
