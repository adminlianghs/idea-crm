package cn.hp.crm.service;

import cn.hp.crm.model.Customer;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.util.List;

public interface CustomerService {
    List<Customer> list();

    PageHelper listByPage(String page, String limit, Customer customer);

    ResultData add(Customer customer);

    ResultData edit(Customer customer);

    ResultData del(String customerId);
}
