package cn.hp.crm.service.impl;

import cn.hp.crm.dao.CustomerStateDao;
import cn.hp.crm.dao.impl.CustomerStateDaoImpl;
import cn.hp.crm.model.CustomerState;
import cn.hp.crm.service.CustomerStateService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.util.List;

public class CustomerStateServiceImpl implements CustomerStateService {
    CustomerStateDao customerStateDao = new CustomerStateDaoImpl();

    @Override
    public PageHelper list(String page, String limit , CustomerState customerState) {
        PageHelper pageHelper = new PageHelper();

        // 设置当前是第几页和这一页的数据个数
        pageHelper.setPage(Integer.parseInt(page));
        pageHelper.setLimit(Integer.parseInt(limit));

        // 获取总数据数量
        int count = customerStateDao.count(customerState);
        // 设置数据总数
        pageHelper.setTotal(count);
        // 设置总页数
        pageHelper.setTotalPage();

        List<CustomerState> states = customerStateDao.list(pageHelper,customerState);
        pageHelper.setData(states);

        return pageHelper;
    }

    @Override
    public ResultData add(CustomerState customerState) {
        int count = customerStateDao.add(customerState);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_ADD_MSG);
        }
        return ResultData.fail(Constant.FAIL_ADD_MSG);
    }

    @Override
    public ResultData edit(CustomerState customerState) {
        int count = customerStateDao.edit(customerState);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_EDIT_MSG);
        }
        return ResultData.fail(Constant.FAIL_EDIT_MSG);
    }

    @Override
    public ResultData delete(CustomerState customerState) {
        int count = customerStateDao.delete(customerState);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_DEL_MSG);
        }
        return ResultData.fail(Constant.FAIL_DEL_MSG);
    }
}
