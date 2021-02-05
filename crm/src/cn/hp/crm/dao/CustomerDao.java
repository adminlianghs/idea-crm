package cn.hp.crm.dao;

import cn.hp.crm.model.Customer;
import cn.hp.crm.util.PageHelper;

import java.util.List;

public interface CustomerDao {

    List<Customer> list() ;

    int count(Customer customer);

    List<Customer> listByPage(PageHelper pageHelper, Customer customer);

    int add(Customer customer);

    int update(Customer customer);

    int delById(String customerId);
}
