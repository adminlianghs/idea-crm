package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.Customer;
import cn.hp.crm.service.CustomerService;
import cn.hp.crm.service.impl.CustomerServiceImpl;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/customer/listPage.do")
public class ListPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        使用分页查询
//        1、获取页面中设置的当前页 以及 每页显示的数量
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");

//       获取搜索参数     //        使用customer对象将数据保存
        Customer customer = new Customer();
        String customerName = req.getParameter("customerName");
        if (customerName != null && customerName.trim() != "") // 出去字符串中的左右空格
            customer.setCustomerName(customerName.trim());
//          String str = "abc"  String str2 = "  abc " ;
        String address = req.getParameter("address");
        if (address!=null && address.trim()!= "")
            customer.setCustomerAddress(address.trim());

        String mobile = req.getParameter("mobile");
        if (mobile !=null && mobile.trim()!="")
            customer.setCustomerMobile(mobile.trim());

        String company = req.getParameter("company");
        if (company !=null && company.trim() !="")
            customer.setCustomerCompany(company.trim());

        String position = req.getParameter("position");
        if (position!=null && position.trim() !="")
            customer.setCustomerPosition(position.trim());

//        使用 String 类型进行操作
        String birth = req.getParameter("birth");
        if ( birth != null && birth.trim() != "")
            customer.setBirth(birth.trim());
//        将String 转成 timeStamp
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
//        Date parse= null ;
//        try {
//           parse  = simpleDateFormat.parse(birthString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Timestamp bi = new Timestamp(parse.getTime());
//        带有时分秒
        String username = req.getParameter("username");
        if (username != null && username.trim() != "")
            customer.setUsername(username.trim());

//        System.out.println(page + "++++++++++++" +limit);
        CustomerService customerService = new CustomerServiceImpl();
//        我要的是当前页中的数据
        PageHelper pageHelper = customerService.listByPage(page , limit , customer);
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
}
