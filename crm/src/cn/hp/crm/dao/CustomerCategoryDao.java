package cn.hp.crm.dao;

import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.util.PageHelper;

import java.util.List;

public interface CustomerCategoryDao {

    int count(CustomerCategory customerCategory);

    List<CustomerCategory> listByPage(PageHelper pageHelper, CustomerCategory customerCategory);

    int add(CustomerCategory customerCategory);

    int update(CustomerCategory customerCategory);

    int delById(String customerCategoryId);
}
