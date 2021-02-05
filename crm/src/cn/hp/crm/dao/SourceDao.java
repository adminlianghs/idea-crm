package cn.hp.crm.dao;


import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.model.Source;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.util.PageHelper;

import java.util.List;

public interface SourceDao {
    int add(Source source) ;

    //查询所有的客户信息来源
    List<Source> list();

    int count(Source source);

    List<Source> listByPage(PageHelper pageHelper, Source source);

    int edit(Source source);

    int delete(Source source);
}
