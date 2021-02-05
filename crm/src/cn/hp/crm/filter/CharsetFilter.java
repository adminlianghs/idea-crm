package cn.hp.crm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 编码格式过滤 ,对所有请求进行过滤
 */
@WebFilter("*.do")
public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        把请求 和响应 都设置了编码格式
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);  // 将设置完编码格式得 请求 和响应对象 放行
    }

    @Override
    public void destroy() {

    }
}
