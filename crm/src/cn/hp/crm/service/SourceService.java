package cn.hp.crm.service;


import cn.hp.crm.model.Source;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public interface SourceService {
    //查询所有的客户来源
    List<Source> list();

    //查询所有的客户来源后分页
    PageHelper listByPage(String page, String limit, Source source);

    ResultData add(Source source);

    ResultData edit(Source source);

    ResultData delete(Source source);
}
