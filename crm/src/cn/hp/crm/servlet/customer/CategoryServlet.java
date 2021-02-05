package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.service.CustomerCategoryService;
import cn.hp.crm.service.impl.CustomerCategoryServiceImpl;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/category.do")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        使用分页查询
//        1、获取页面中设置的当前页 以及 每页显示的数量
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

//       获取搜索参数     //        使用customerCategory对象将数据保存
        CustomerCategory customerCategory = new CustomerCategory();
        String customerCategoryName = req.getParameter("customerCategoryName");
        if (customerCategoryName != null && customerCategoryName.trim() != "") {
            customerCategory.setCustomerCategoryName(customerCategoryName);
        }

        String customerCategoryIdStr = req.getParameter("customerCategoryId");
        if (customerCategoryIdStr!=null && customerCategoryIdStr.trim() != "") {
            int customerCategoryId = Integer.parseInt(customerCategoryIdStr);
            customerCategory.setCustomerCategoryId(customerCategoryId);
        }

        String customerCategoryDesc = req.getParameter("customerCategoryDesc");
        if (customerCategoryDesc !=null && customerCategoryDesc.trim() !="") {
            customerCategory.setCustomerCategoryDesc(customerCategoryDesc);
        }


//        System.out.println(page + "++++++++++++" +limit);
        CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();
//        我要的是当前页中的数据
        PageHelper pageHelper = customerCategoryService.listByPage(page , limit , customerCategory);
//       将数据响应给前端页面
        resp.getWriter().println(JSONUtil.parseObj(ResultData.success("",pageHelper)));

//        到前端的数据样式： resultData { "code":200 ,
//                                       "msg":"" ,
//                                       "data": pageHelper{ "total":35 ,
//                                                            "totalPage":4,
//                                                            "limit":10 ,
//                                                            "data": list<Customer>  }
//                                     }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
