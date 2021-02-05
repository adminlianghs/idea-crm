package cn.hp.crm.servlet.user;

import cn.hp.crm.util.SessionKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/loginOut.do")
public class LoginOutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        进行清空session域中的数据，
        req.getSession().removeAttribute(SessionKey.USER_KEY);
//        将页面重定向到登录首页
        resp.sendRedirect("/login.jsp");
    }
}
