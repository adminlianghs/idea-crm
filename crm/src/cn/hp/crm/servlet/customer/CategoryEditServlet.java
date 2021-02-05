package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.model.User;
import cn.hp.crm.service.CustomerCategoryService;
import cn.hp.crm.service.impl.CustomerCategoryServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/categoryEdit.do")
public class CategoryEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//         获取前端页面传递的参数  不再使用验证，因为前端进行了非空验证， 但是 前端的安全性低，大部分项目 会在后端进行再次验证
        String customerCategoryName = request.getParameter("customerCategoryName");
        String customerCategoryDesc = request.getParameter("customerCategoryDesc");
        String remark = request.getParameter("remark");
        CustomerCategory customerCategory = new CustomerCategory(customerCategoryName,customerCategoryDesc,remark);
        // 设置当前信息的id
        int customerCategoryId = Integer.parseInt(request.getParameter("customerCategoryId"));
        customerCategory.setCustomerCategoryId(customerCategoryId);
        //        将当前登录的操作员 的id进行保存， 用于设置当前用户的修改人id
        User user = (User) request.getSession().getAttribute(SessionKey.USER_KEY);
        customerCategory.setUpdater(user.getUserId());
//        System.out.println(customerCategory.toString());
//        拿到了页面新增数据
        CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl() ;
        ResultData resultData = customerCategoryService.edit(customerCategory);
//        向页面中返回数据
        response.getWriter().println(JSONUtil.parseObj(resultData));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
