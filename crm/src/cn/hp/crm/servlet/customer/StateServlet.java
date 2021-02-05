package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerState;
import cn.hp.crm.service.CustomerStateService;
import cn.hp.crm.service.impl.CustomerStateServiceImpl;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/state.do")
public class StateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String customerStateId = request.getParameter("customerStateId");
        String customerStateName = request.getParameter("customerStateName");
        String customerStateDesc = request.getParameter("customerStateDesc");

        CustomerState customerState = new CustomerState();
        if(customerStateId != null && customerStateId.trim() != ""){
            customerState.setCustomerStateId(Integer.parseInt(customerStateId));
        }
        if(customerStateName != null && customerStateName.trim() != ""){
            customerState.setCustomerStateName(customerStateName);
        }
        if(customerStateDesc != null && customerStateDesc.trim() != ""){
            customerState.setCustomerStateDesc(customerStateDesc);
        }

        CustomerStateService customerStateService = new CustomerStateServiceImpl();
        PageHelper pageHelper = customerStateService.list(page, limit ,customerState);
        response.getWriter().println(JSONUtil.parseObj(ResultData.success("",pageHelper)));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
