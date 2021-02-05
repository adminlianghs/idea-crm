package cn.hp.crm.service.impl;


import cn.hp.crm.dao.SourceDao;
import cn.hp.crm.dao.impl.SourceDaoImpl;
import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.model.Source;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public class SourceServiceImpl implements SourceService {
    private SourceDao sourceDao =new SourceDaoImpl();
    //查询所有的客户来源信息
    @Override
    public List<Source> list() {
        return   sourceDao.list();
    }

    @Override
    public PageHelper listByPage(String page, String limit, Source source) {
        //        返回一个pageHelper对象
        PageHelper pageHelper = new PageHelper() ;
//       设置当前页
        pageHelper.setPage(Integer.parseInt(page));
//        设置每页的数据条数
        pageHelper.setLimit(Integer.parseInt(limit));
//      总条数  从数据库中查询  附带参数的查询
        int count = sourceDao.count(source);
        pageHelper.setTotal(count);
//        设置总页数
        pageHelper.setTotalPage();
//        设置当前页面中的数据  进行 附带参数的查询
        List<Source> sources = sourceDao.listByPage(pageHelper ,source);
        pageHelper.setData(sources);

        return pageHelper ;
    }

    @Override
    public ResultData add(Source source) {
        int count = sourceDao.add(source);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_ADD_MSG);
        }
        return ResultData.fail(Constant.FAIL_ADD_MSG);
    }

    @Override
    public ResultData edit(Source source) {
        int count = sourceDao.edit(source);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_EDIT_MSG);
        }
        return ResultData.fail(Constant.FAIL_EDIT_MSG);
    }

    @Override
    public ResultData delete(Source source) {
        int count = sourceDao.delete(source);
        if(count > 0){
            return ResultData.success(Constant.SUCCESS_DEL_MSG);
        }
        return ResultData.fail(Constant.FAIL_EDIT_MSG);
    }
}
