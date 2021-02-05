package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.Customer;
import cn.hp.crm.service.CustomerService;
import cn.hp.crm.service.impl.CustomerServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/list.do")
public class ListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        不分页，不查询
        CustomerService customerService = new CustomerServiceImpl();
//        获取前端传递的查询数据
//        String parameter = req.getParameter("xxx");
        List<Customer> customers =  customerService.list();
        System.out.println(customers);
        resp.getWriter().println(JSONUtil.parseObj(ResultData.success("",customers)));
    }
}
