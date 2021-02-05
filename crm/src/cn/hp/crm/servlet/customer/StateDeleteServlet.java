package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerState;
import cn.hp.crm.service.CustomerStateService;
import cn.hp.crm.service.impl.CustomerStateServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/stateDel.do")
public class StateDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String customerStateId = request.getParameter("customerStateId");
        CustomerState customerState = new CustomerState();
        customerState.setCustomerStateId(Integer.parseInt(customerStateId));

        CustomerStateService customerStateService = new CustomerStateServiceImpl();
        ResultData resultData = customerStateService.delete(customerState);

        response.getWriter().println(JSONUtil.parseObj(resultData));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
