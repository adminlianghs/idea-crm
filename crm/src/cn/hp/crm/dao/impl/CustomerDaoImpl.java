package cn.hp.crm.dao.impl;

import cn.hp.crm.dao.CustomerDao;
import cn.hp.crm.model.Customer;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.DBUtil;
import cn.hp.crm.util.PageHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    protected Customer fillObject(ResultSet set)throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerStateName(set.getString("customer_state_name"));
        customer.setCustomerStateId(set.getInt("customer_state_id"));
        customer.setCustomerId(set.getString("customer_id"));
//        将事件格式改成字符串 ， 当成字符使用
//        customer.setCustomerBirth(set.getTimestamp("customer_birth"));
        customer.setBirth(set.getString("customer_birth"));
        customer.setCustomerTel(set.getString("customer_tel"));
        customer.setCustomerRemark(set.getString("customer_remark"));
        customer.setCustomerQq(set.getString("customer_qq"));
        customer.setCustomerPosition(set.getString("customer_position"));
        customer.setCustomerName(set.getString("customer_name"));
        customer.setCustomerMobile(set.getString("customer_mobile"));
        customer.setCustomerIsMale(set.getByte("customer_is_male"));
        customer.setCustomerEmail(set.getString("customer_email"));
        customer.setCustomerCompany(set.getString("customer_company"));
        customer.setCustomerBlog(set.getString("customer_blog"));
        customer.setCustomerAddress(set.getString("customer_address"));
        customer.setUsername(set.getString("username"));
        customer.setUserId(set.getInt("user_id"));
        customer.setUpdateTime(set.getTimestamp("update_time"));
        customer.setUpdater(set.getInt("updater"));
        customer.setStatus(set.getByte("status"));
        customer.setRemark(set.getString("remark"));
        customer.setCustomerSourceName(set.getString("customer_source_name"));
        customer.setCustomerSourceId(set.getInt("customer_source_id"));
        customer.setCustomerCategoryId(set.getInt("customer_category_id"));
        customer.setCustomerCategoryName(set.getString("customer_category_name"));
        customer.setCreateTime(set.getTimestamp("create_time"));
        customer.setCreater(set.getInt("creater"));
        return customer ;
    }

//    第一个参数 用来进行搜索  第二参数 用来进行分页查询 第三个参数 用来进行区分是 单行单列 还是多行多列
    protected String getSql(Customer customer ,PageHelper pageHelper, boolean flag ){
        StringBuffer sb = new StringBuffer();//  5表联查  每个表中的数据  必须是状态为 2
        if(flag){ // true 单行单列
            sb.append("select count(*) from customer c ");
        }else{
            sb.append("select c.* , cs.customer_state_name , cso.customer_source_name , cc.customer_category_name , u.username from customer c ");
        }
        sb.append("left join customer_state cs on c.customer_state_id = cs.customer_state_id and cs.status = 2 ");
        sb.append("left join customer_source cso on c.customer_source_id = cso.customer_source_id and cso.status = 2 ");
        sb.append("left join customer_category cc on c.customer_category_id = cc.customer_category_id and cc.status = 2 ");
        sb.append("left join user u on c.user_id = u.user_id and u.status =2 ");
        sb.append("where c.status = 2 ");
//         会造成sql注入问题  自己补齐
        if (customer.getUsername() != null && customer.getUsername() != ""){
            sb.append(" and u.username like '%" + customer.getUsername() + "%' " );
        }
        if (customer.getCustomerAddress()!=null &&customer.getCustomerAddress() != ""){
            sb.append( " and c.customer_address like '%"+ customer.getCustomerAddress() + "%' ");
        }
        if (customer.getCustomerName() != null && customer.getCustomerName() !=""){
            sb.append(" and c.customer_name like '%"+ customer.getCustomerName()+"%' ");
        }
        if (customer.getBirth() != null && customer.getBirth() != "") {
            sb.append(" and c.customer_birth like '%"+ customer.getBirth().substring(5)+"%'  ");
        }


//        分页查询
//        第一页的数据  page:1 limit:10   查询sql: limit 0 , 10
//        第二页的数据  page:2 limit:10   查询sql: limit 10 , 10
//        第三页的数据  page:3 limit:10   查询sql: limit 20 , 10 (当前页-1)*每页条数   , 每页条数
        if (pageHelper != null){
            sb.append(" limit " + (pageHelper.getPage()-1)*pageHelper.getLimit()  + " , "+ pageHelper.getLimit());
        }
        return sb.toString();

    }

//    不分页的查询
    @Override
    public List<Customer> list() {
        return listByPage(null, null);
    }

//    查询总条数
    @Override
    public int count(Customer customer) {
       String sql = getSql(customer, null, true);
        Object[] objects = {};
        ResultSet select = DBUtil.select(sql, objects);
        try {
            if (select.next()){
                return select.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Constant.TOTAL_ERROR;
    }

    /**
     *  查询当前页面中的数据
     * @param pageHelper
     * @param customer
     * @return
     */
    @Override
    public List<Customer> listByPage(PageHelper pageHelper, Customer customer) {
        String sql = getSql(customer,pageHelper,false );
        Object [] objects = {} ;
        ResultSet select = DBUtil.select(sql, objects);
        List<Customer> customers = new ArrayList<>();
        try {
            while (select.next()){
                Customer customer1 = fillObject(select);
                customers.add(customer1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customers ;
    }

    @Override
    public int add(Customer customer) {
        String sql = "insert into customer(customer_state_id,customer_source_id,customer_category_id,user_id,customer_name,customer_mobile,customer_address,customer_position,customer_birth,customer_company ,status ,create_time ,creater) " +
                "values (?,?,?,?,?,?,?,?,?,?,2 , now(),?)";
        Object[] objects = {customer.getCustomerStateId() , customer.getCustomerSourceId() , customer.getCustomerCategoryId(),customer.getUserId() , customer.getCustomerName() , customer.getCustomerMobile() , customer.getCustomerAddress() , customer.getCustomerPosition(),customer.getBirth(), customer.getCustomerCompany(), customer.getCreater()};
        int update = DBUtil.update(sql, objects);
        return update;
    }

    @Override
    public int update(Customer customer) {
        String sql = "update customer set  customer_state_id = ? ,customer_source_id = ? ,customer_category_id = ?,user_id = ? ,customer_name = ? , customer_mobile = ? ,customer_address = ?,customer_position =? ,customer_birth = ?,customer_company= ? ,update_time = now(),updater = ?  where customer_id = ?  ";
        Object[] objects = {customer.getCustomerStateId() , customer.getCustomerSourceId() , customer.getCustomerCategoryId(),customer.getUserId() , customer.getCustomerName() , customer.getCustomerMobile() , customer.getCustomerAddress() , customer.getCustomerPosition(),customer.getBirth(), customer.getCustomerCompany(), customer.getUpdater(),customer.getCustomerId()};
        int update = DBUtil.update(sql, objects);
        return update ;
    }

//    删除使用假删除
    @Override
    public int delById(String customerId) {
        String sql = "update customer set status = -2 where customer_id = ?";
        Object[] objects = {customerId};
        int update = DBUtil.update(sql, objects);
        return update ;
    }
}
