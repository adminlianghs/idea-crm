package cn.hp.crm.dao;

import cn.hp.crm.model.CustomerState;
import cn.hp.crm.util.PageHelper;

import java.util.List;

public interface CustomerStateDao {
    List<CustomerState> list(PageHelper pageHelper, CustomerState customerState);

    int count(CustomerState customerState);

    int add(CustomerState customerState);

    int edit(CustomerState customerState);

    int delete(CustomerState customerState);
}
