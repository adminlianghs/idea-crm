package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.Source;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.service.impl.SourceServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/sourceDel.do")
public class SourceDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String customerSourceId = request.getParameter("customerSourceId");
        Source source = new Source(Integer.parseInt(customerSourceId));

        SourceService sourceService = new SourceServiceImpl();
        ResultData resultData = sourceService.delete(source);

        response.getWriter().println(JSONUtil.parseObj(resultData));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
