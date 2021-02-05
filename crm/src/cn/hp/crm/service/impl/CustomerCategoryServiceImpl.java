package cn.hp.crm.service.impl;

import cn.hp.crm.dao.CustomerCategoryDao;
import cn.hp.crm.dao.impl.CustomerCategoryDaoImpl;
import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.service.CustomerCategoryService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.util.List;

public class CustomerCategoryServiceImpl implements CustomerCategoryService {

    private CustomerCategoryDao customerCategoryDao = new CustomerCategoryDaoImpl();

    @Override
    public List<CustomerCategory> list() {
        return null;
    }

    @Override
    public PageHelper listByPage(String page, String limit, CustomerCategory customerCategory) {
        //        返回一个pageHelper对象
        PageHelper pageHelper = new PageHelper() ;
//       设置当前页
        pageHelper.setPage(Integer.parseInt(page));
//        设置每页的数据条数
        pageHelper.setLimit(Integer.parseInt(limit));
//      总条数  从数据库中查询  附带参数的查询
        int count = customerCategoryDao.count(customerCategory);
        pageHelper.setTotal(count);
//        设置总页数
        pageHelper.setTotalPage();
//        设置当前页面中的数据  进行 附带参数的查询
        List<CustomerCategory> customers = customerCategoryDao.listByPage(pageHelper ,customerCategory);
        pageHelper.setData(customers);

        return pageHelper ;
    }

    /**
     * 新增方法
     * @param customerCategory
     * @return
     */
    @Override
    public ResultData add(CustomerCategory customerCategory) {
        int count = customerCategoryDao.add(customerCategory);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_ADD_MSG);
        }
        return ResultData.fail(Constant.FAIL_ADD_MSG);
    }

    @Override
    public ResultData edit(CustomerCategory customerCategory) {
        int count = customerCategoryDao.update(customerCategory);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_EDIT_MSG);
        }
        return ResultData.fail(Constant.FAIL_EDIT_MSG);
    }

    @Override
    public ResultData del(String customerCategoryId) {
        int count = customerCategoryDao.delById(customerCategoryId);
        if (count > 0 ){
            return ResultData.success(Constant.SUCCESS_DEL_MSG);
        }
        return ResultData.fail(Constant.FAIL_DEL_MSG);
    }
}
