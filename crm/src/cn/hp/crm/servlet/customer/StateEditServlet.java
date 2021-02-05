package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerState;
import cn.hp.crm.model.User;
import cn.hp.crm.service.CustomerStateService;
import cn.hp.crm.service.impl.CustomerStateServiceImpl;
import cn.hp.crm.util.ResultData;
import cn.hp.crm.util.SessionKey;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/stateEdit.do")
public class StateEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String customerStateName = request.getParameter("customerStateName");
        String customerStateDesc = request.getParameter("customerStateDesc");
        String remark = request.getParameter("remark");
        CustomerState customerState = new CustomerState(customerStateName,customerStateDesc,remark);
        String customerStateId = request.getParameter("customerStateId");
        customerState.setCustomerStateId(Integer.parseInt(customerStateId));
        User user = (User)request.getSession().getAttribute(SessionKey.USER_KEY);
        customerState.setUpdater(user.getUserId());

        CustomerStateService customerStateService = new CustomerStateServiceImpl();
        ResultData resultData = customerStateService.edit(customerState);

        response.getWriter().println(JSONUtil.parseObj(resultData));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
