package cn.hp.crm.servlet.customer;

import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.model.Source;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.service.impl.SourceServiceImpl;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/source.do")
public class SourceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //        使用分页查询
//        1、获取页面中设置的当前页 以及 每页显示的数量
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        //       获取搜索参数     //        使用customerCategory对象将数据保存
        Source source = new Source();
        String sourceName = request.getParameter("customerSourceName");
        if (sourceName != null && sourceName.trim() != "") {
            source.setCustomerSourceName(sourceName);
        }

        String sourceIdStr = request.getParameter("customerSourceId");
        if (sourceIdStr!=null && sourceIdStr.trim() != "") {
            int sourceId = Integer.parseInt(sourceIdStr);
            source.setCustomerSourceId(sourceId);
        }

        String sourceDesc = request.getParameter("customerSourceDesc");
        if (sourceDesc !=null && sourceDesc.trim() !="") {
            source.setCustomerSourceDesc(sourceDesc);
        }

        //实例化servlet
        SourceService sourceService =new SourceServiceImpl();
//        List<Source> sources =  sourceService.list();
//        System.out.println(sources.size());
        PageHelper pageHelper = sourceService.listByPage(page , limit , source);
//        System.out.println(pageHelper.getData().toString());
        response.getWriter().println(JSONUtil.parseObj(ResultData.success("",pageHelper)));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
