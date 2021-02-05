package cn.hp.crm.servlet.user;

import cn.hp.crm.util.SessionKey;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 获取验证码  web.xml  或者 @WebServlet注解
 */
@WebServlet("/user/getCode")
public class GetCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        第一步生成图片
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(400, 100, 4, 4);
//        第二步，将图片中的验证码值 存到session中，用于登录验证
        req.getSession().setAttribute(SessionKey.CODE_KEY,captcha.getCode());
//        最终将图片写入到页面中
        captcha.write(resp.getOutputStream());
    }
}
