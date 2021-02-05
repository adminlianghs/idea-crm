package cn.hp.crm.servlet.user;

import cn.hp.crm.model.User;
import cn.hp.crm.service.UserService;
import cn.hp.crm.service.impl.UserServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/changePassword.do")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置编码格式得事  已经由过滤器做过了
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");

        UserService userService = new UserServiceImpl();
//        获取当前修改得用户id
        User user = (User) req.getSession().getAttribute(SessionKey.USER_KEY);
//        修改密码业务
        ResultData resultData = userService.changePassword(user.getUserId(),password,newPassword);

        resp.getWriter().println(JSONUtil.parseObj(resultData));
    }
}
