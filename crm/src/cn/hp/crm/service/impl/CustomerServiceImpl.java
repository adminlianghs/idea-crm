package cn.hp.crm.service.impl;

import cn.hp.crm.dao.CustomerDao;
import cn.hp.crm.dao.impl.CustomerDaoImpl;
import cn.hp.crm.model.Customer;
import cn.hp.crm.service.CustomerService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> list() {
        return customerDao.list();
    }

    @Override
    public PageHelper listByPage(String page, String limit, Customer customer) {
//        返回一个pageHelper对象
        PageHelper pageHelper = new PageHelper() ;
//       设置当前页
        pageHelper.setPage(Integer.parseInt(page));
//        设置每页的数据条数
        pageHelper.setLimit(Integer.parseInt(limit));
//      总条数  从数据库中查询  附带参数的查询
        int count = customerDao.count(customer);
        pageHelper.setTotal(count);
//        设置总页数
        pageHelper.setTotalPage();
//        设置当前页面中的数据  进行 附带参数的查询
        List<Customer> customers = customerDao.listByPage(pageHelper ,customer);
        pageHelper.setData(customers);

        return pageHelper ;
    }

//  新增方法
    @Override
    public ResultData add(Customer customer) {
        int count = customerDao.add(customer);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_ADD_MSG);
        }
        return ResultData.fail(Constant.FAIL_ADD_MSG);
    }

    @Override
    public ResultData edit(Customer customer) {
        int count = customerDao.update(customer);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_EDIT_MSG);
        }
        return ResultData.fail(Constant.FAIL_EDIT_MSG);
    }

    @Override
    public ResultData del(String customerId) {
        int count = customerDao.delById(customerId);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_DEL_MSG);
        }
        return ResultData.fail(Constant.FAIL_DEL_MSG);
    }

}
