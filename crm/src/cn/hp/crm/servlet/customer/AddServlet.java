package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.Customer;
import cn.hp.crm.model.User;
import cn.hp.crm.service.CustomerService;
import cn.hp.crm.service.impl.CustomerServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/add.do")  // 所有的servlet路径 全部都是以 / 开头
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//         获取前端页面传递的参数  不再使用验证，因为前端进行了非空验证， 但是 前端的安全性低，大部分项目 会在后端进行再次验证
        String customerName = req.getParameter("customerName");
        String address = req.getParameter("address");
        String birth = req.getParameter("birth"); // timeStamp  年月日 时分秒
        String company = req.getParameter("company");
        int customerCategoryId = Integer.parseInt(req.getParameter("customerCategoryId")); // int
        int customerSourceId = Integer.parseInt(req.getParameter("customerSourceId")); // int
        int customerStateId = Integer.parseInt(req.getParameter("customerStateId")); // int
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");
        int userId = Integer.parseInt(req.getParameter("userId"));  // int

        Customer customer = new Customer(customerName
                ,address
                ,birth
                ,company
                ,phone
                ,position
                ,customerCategoryId
                ,customerSourceId
                ,customerStateId
                ,userId);
//        将当前登录的操作员 的id进行保存， 用于设置当前用户的创建人id
        User user = (User) req.getSession().getAttribute(SessionKey.USER_KEY);
        customer.setCreater(user.getUserId());
//        拿到了页面新增数据
        CustomerService customerService = new CustomerServiceImpl() ;
        ResultData resultData = customerService.add(customer);
//        向页面中返回数据
        resp.getWriter().println(JSONUtil.parseObj(resultData));

    }
}
