package cn.hp.crm.dao.impl;

import cn.hp.crm.dao.CustomerStateDao;
import cn.hp.crm.model.CustomerState;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.DBUtil;
import cn.hp.crm.util.PageHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerStateDaoImpl implements CustomerStateDao {

    @Override
    public List<CustomerState> list(PageHelper pageHelper, CustomerState customerState) {
        String sql = getSql(customerState,pageHelper,false);
        Object[] objects = {};
        ResultSet resultSet = DBUtil.select(sql, objects);
        List<CustomerState> states = new ArrayList<>();
        try {
            while (resultSet.next()){
                CustomerState state = fileObject(resultSet);
                states.add(state);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return states;
    }

    protected CustomerState fileObject(ResultSet resultSet) throws SQLException {
        CustomerState customerState = new CustomerState();
        customerState.setCustomerStateId(resultSet.getInt("customer_state_id"));
        customerState.setCustomerStateName(resultSet.getString("customer_state_name"));
        customerState.setCustomerStateDesc(resultSet.getString("customer_state_desc"));
        customerState.setCreater(resultSet.getInt("creater"));
        customerState.setCreateTime(resultSet.getString("create_time"));
        customerState.setRemark(resultSet.getString("remark"));
        customerState.setStatus(resultSet.getInt("status"));
        customerState.setUpdater(resultSet.getInt("updater"));
        customerState.setUpdateTime(resultSet.getString("update_time"));
        return customerState;
    }

    @Override
    public int count(CustomerState customerState) {
        String sql = getSql(customerState,null,true);
        Object[] objects = {};
        ResultSet resultData = DBUtil.select(sql,objects);
        try {
            if(resultData.next()){
                return resultData.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Constant.TOTAL_ERROR;
    }

    @Override
    public int add(CustomerState customerState)  {
        String sql = "insert into customer_state (customer_state_name,customer_state_desc,remark,creater,create_time) values(?,?,?,?,now())";
        Object[] objects = {customerState.getCustomerStateName(),customerState.getCustomerStateDesc(),customerState.getRemark(),customerState.getCreater()};
        int count = DBUtil.update(sql,objects);
        return count;
    }

    @Override
    public int edit(CustomerState customerState) {
        String sql = "update customer_state set customer_state_name = ? ,customer_state_desc=?,remark=?,updater=?,update_time=now() where customer_state_id = ? ";
        Object[] objects = {customerState.getCustomerStateName(),customerState.getCustomerStateDesc(),customerState.getRemark(),customerState.getUpdater(),customerState.getCustomerStateId()};
        int count = DBUtil.update(sql,objects);
        return count;
    }

    @Override
    public int delete(CustomerState customerState) {
        String sql = "update customer_state set status = -2 where customer_state_id = ? ";
        Object[] objects = {customerState.getCustomerStateId()};
        int count = DBUtil.update(sql,objects);
        return count;
    }

    /**
     * 根据不同的请求 获取sql语句
     * @param customerState
     * @param pageHelper
     * @param flag
     * @return
     */
    protected String getSql(CustomerState customerState, PageHelper pageHelper, boolean flag) {
        StringBuffer stringBuffer = new StringBuffer();
        if(flag){
            stringBuffer.append("select count(*) from customer_state ");
        }else{
            stringBuffer.append("select * from customer_state ");
        }
        stringBuffer.append("where status = 2 ");
        if(customerState.getCustomerStateId() != null && customerState.getCustomerStateId()!= 0){
            stringBuffer.append("and customer_state_id like '%"+customerState.getCustomerStateId()+"%' ");
        }
        if(customerState.getCustomerStateName() != null && customerState.getCustomerStateName() != ""){
            stringBuffer.append("and customer_state_name like'%"+customerState.getCustomerStateName()+"%' ");
        }
        if(customerState.getCustomerStateDesc() != null && customerState.getCustomerStateDesc() != ""){
            stringBuffer.append("and customer_status_desc like '%"+customerState.getCustomerStateDesc()+"%' ");
        }
        if(pageHelper != null){
            stringBuffer.append("limit "+((pageHelper.getPage()-1)*pageHelper.getLimit())+","+pageHelper.getLimit());
        }

        return stringBuffer.toString();
    }
}
