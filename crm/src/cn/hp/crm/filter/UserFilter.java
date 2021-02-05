package cn.hp.crm.filter;

import cn.hp.crm.model.User;
import cn.hp.crm.util.SessionKey;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        获取http协议的request对象    filterChain 用来放行请求得对象
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        User user = (User) request.getSession().getAttribute(SessionKey.USER_KEY);
        if (user != null && user.getUsername() != ""){
            filterChain.doFilter(request ,response); // 将请求放行，不过滤
        }else {
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
