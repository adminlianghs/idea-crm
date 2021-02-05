package cn.hp.crm.dao.impl;


import cn.hp.crm.dao.SourceDao;
import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.model.Source;
import cn.hp.crm.service.SourceService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.DBUtil;
import cn.hp.crm.util.PageHelper;
import cn.hutool.db.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SourceDaoImpl implements SourceDao {

    @Override
    public int add(Source source) {
        String sql = "insert into customer_source(customer_source_name,customer_source_desc,remark,creater,create_time) values(?,?,?,?,now())";
        Object[] objects = {source.getCustomerSourceName(),source.getCustomerSourceDesc(),source.getRemark(),source.getCreater()};
        int update = DBUtil.update(sql,objects);
        return update;
    }

    /**
     * 不分页查询
     *
     * @return
     */
    @Override
    public List<Source> list() {
        //准备sql语句
        String sql = "select * from customer_source where status = 2";
        ResultSet select = DBUtil.select(sql, new Object[]{});
        List<Source> sources = new ArrayList<>();
        try {
            while (select.next()) {
                Source source = fillObject(select);
                sources.add(source);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return sources;
    }

    @Override
    public int count(Source source) {
        String sql = getSql(source, null, true);
        Object[] objects = {};
        ResultSet select = DBUtil.select(sql, objects);
        try {
            if (select.next()) {
                return select.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Constant.TOTAL_ERROR;
    }

    @Override
    public List<Source> listByPage(PageHelper pageHelper, Source source) {
        String sql = getSql(source, pageHelper, false);
        Object[] objects = {};
        ResultSet select = DBUtil.select(sql, objects);
//        System.out.println(sql);
        List<Source> sources = new ArrayList<>();
        try {
            while (select.next()) {
                Source source1 = fillObject(select);
                sources.add(source1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sources;
    }

    @Override
    public int edit(Source source) {
        String sql = "update customer_source set customer_source_name=? , customer_source_desc = ?, remark = ?, updater = ?, update_time = now() where customer_source_id = ?";
        Object[] objects = {source.getCustomerSourceName(),source.getCustomerSourceDesc(),source.getRemark(),source.getUpdater(),source.getCustomerSourceId()};
        int count = DBUtil.update(sql,objects);
        return count;
    }

    @Override
    public int delete(Source source) {
        String sql = "update customer_source set status = -2 where customer_source_id = ?";
        Object[] objects = {source.getCustomerSourceId()};
        int count = DBUtil.update(sql,objects);
        return count;
    }

    /**
     * 获取sql语句
     *
     * @param source
     * @param pageHelper
     * @param flag
     * @return String
     */
    private String getSql(Source source, PageHelper pageHelper, boolean flag) {
        StringBuffer sb = new StringBuffer();//每个表中的数据  必须是状态为 2
        if (flag) { // true 单行单列
            sb.append("select count(*) from customer_source c ");
        } else {
            sb.append("select c.* from customer_source c ");
        }

        sb.append("where c.status = 2 ");
//         会造成sql注入问题  自己补齐
        if (source.getCustomerSourceName() != null && source.getCustomerSourceName() != "") {
            sb.append(" and c.customer_source_name like '%" + source.getCustomerSourceName() + "%' ");
        }
        if (source.getCustomerSourceDesc() != null && source.getCustomerSourceDesc() != "") {
            sb.append(" and c.customer_source_Desc like '%" + source.getCustomerSourceDesc() + "%' ");
        }
        if (source.getCustomerSourceId()!=null && source.getCustomerSourceId() != 0 ){
          sb.append(" and c.customer_source_Id like '%" + source.getCustomerSourceId() + "%' ");
        }

//        分页查询
//        第一页的数据  page:1 limit:10   查询sql: limit 0 , 10
//        第二页的数据  page:2 limit:10   查询sql: limit 10 , 10
//        第三页的数据  page:3 limit:10   查询sql: limit 20 , 10 (当前页-1)*每页条数   , 每页条数
        if (pageHelper != null) {
            sb.append(" limit " + (pageHelper.getPage() - 1) * pageHelper.getLimit() + " , " + pageHelper.getLimit());
        }
        return sb.toString();

    }

    //提取的resuset接收的值
    protected Source fillObject(ResultSet set) throws SQLException {
        Source source = null;
        source = new Source();
        source.setUpdater(set.getInt("updater"));
        source.setUpdateTime(set.getString("update_time"));
        source.setStatus(set.getString("status"));
        source.setRemark(set.getString("remark"));
        source.setCustomerSourceId(set.getInt("customer_source_id"));
        source.setCustomerSourceName(set.getString("customer_source_name"));
        source.setCustomerSourceDesc(set.getString("customer_source_desc"));
        source.setCreater(set.getInt("creater"));
        return source;
    }
}
