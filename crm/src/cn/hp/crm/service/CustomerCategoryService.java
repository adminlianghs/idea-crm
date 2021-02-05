package cn.hp.crm.service;

import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.util.List;

public interface CustomerCategoryService {

    List<CustomerCategory> list();

    PageHelper listByPage(String page, String limit, CustomerCategory customerCategory);

    ResultData add(CustomerCategory customerCategory);

    ResultData edit(CustomerCategory customerCategory);

    ResultData del(String customerCategoryId);
}
