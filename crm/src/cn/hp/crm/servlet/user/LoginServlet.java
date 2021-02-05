package cn.hp.crm.servlet.user;

import cn.hp.crm.model.User;
import cn.hp.crm.service.UserService;
import cn.hp.crm.service.impl.UserServiceImpl;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 登录的方法， 用来获取账号、密码
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置请求的编码格式 和响应的编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

//        后端验证、先验证验证码的正确性
        String userCode = req.getParameter("captcha");
        String code = req.getSession().getAttribute(SessionKey.CODE_KEY).toString();
//        判断对象 使用equals
        if (userCode.equals(code)){
//            开始验证 用户名 密码
            String username = req.getParameter("username");
            String password = req.getParameter("password");
//            servlet层  视图层 --> 业务逻辑层
            UserService userService = new UserServiceImpl();
//            使用业务逻辑名称进行命名
            User user = userService.login(username , password);
            if (user != null) { // 将user对象 改成json对象
//                JSONObject jsonObject = JSONUtil.parseObj(user);
                req.getSession().setAttribute(SessionKey.USER_KEY,user);  // 以浏览器为基础
//                将用户的 验证码进行清除
                req.getSession().removeAttribute(SessionKey.CODE_KEY);
                ResultData resultData = ResultData.success(Constant.SUCCESS_LOGIN_MSG, user);
                JSONObject jsonObject = JSONUtil.parseObj(resultData);
                resp.getWriter().println(jsonObject);
            }else {
                resp.getWriter().println(JSONUtil.parseObj(ResultData.fail(Constant.FAIL_LOGIN_MSG)));
            }
        }else {  // 使用对象保存数据  java对象 Object     js对象 json
            resp.getWriter().println(JSONUtil.parseObj(ResultData.fail(Constant.FAIL_CODE_MSG)));
        }

    }
}
