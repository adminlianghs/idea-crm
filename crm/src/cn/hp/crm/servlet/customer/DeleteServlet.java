package cn.hp.crm.servlet.customer;

import cn.hp.crm.service.CustomerService;
import cn.hp.crm.service.impl.CustomerServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/del.do")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//         获取前端页面传递的参数  不再使用验证，因为前端进行了非空验证， 但是 前端的安全性低，大部分项目 会在后端进行再次验证
        String customerId = req.getParameter("customerId");

        System.out.println("-------------" + customerId);
        CustomerService customerService = new CustomerServiceImpl();
        ResultData resultData = customerService.del(customerId);
        resp.getWriter().println(JSONUtil.parseObj(resultData));
    }
}
