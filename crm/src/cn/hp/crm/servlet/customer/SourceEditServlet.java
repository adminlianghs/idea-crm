package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.Source;
import cn.hp.crm.model.User;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.service.impl.SourceServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/customer/sourceEdit.do")
public class SourceEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String customerSourceName = request.getParameter("customerSourceName");
        String customerSourceDesc = request.getParameter("customerSourceDesc");
        String remark = request.getParameter("remark");
        Source source = new Source(customerSourceName,customerSourceDesc,remark);
//        System.out.println(source);
        String customerSourceId = request.getParameter("customerSourceId");
//        System.out.println(customerSourceId);
        source.setCustomerSourceId(Integer.parseInt(customerSourceId));
//        System.out.println(source);
        User user = (User)request.getSession().getAttribute(SessionKey.USER_KEY);
        source.setUpdater(user.getUserId());
//        System.out.println(source);
        SourceService sourceService = new SourceServiceImpl();
        ResultData resultData = sourceService.edit(source);

        response.getWriter().println(JSONUtil.parseObj(resultData));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
