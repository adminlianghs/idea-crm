package cn.hp.crm.dao.impl;

import cn.hp.crm.dao.CustomerCategoryDao;
import cn.hp.crm.model.CustomerCategory;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.DBUtil;
import cn.hp.crm.util.PageHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerCategoryDaoImpl implements CustomerCategoryDao {

    protected CustomerCategory fillObject(ResultSet set)throws SQLException {
        CustomerCategory customerCategory = null ;
        customerCategory = new CustomerCategory();
        customerCategory.setCustomerCategoryId(set.getInt("customer_category_id"));
        customerCategory.setCustomerCategoryName(set.getString("Customer_Category_Name"));
        customerCategory.setCustomerCategoryDesc(set.getString("Customer_Category_Desc"));
        customerCategory.setRemark(set.getString("remark"));
        customerCategory.setUpdateTime(set.getString("update_time"));
        customerCategory.setUpdater(set.getInt("updater"));
        customerCategory.setStatus(set.getInt("status"));
        customerCategory.setCreateTime(set.getString("create_time"));
        customerCategory.setCreater(set.getInt("creater"));
        return customerCategory ;
    }

    //    第一个参数 用来进行搜索  第二参数 用来进行分页查询 第三个参数 用来进行区分是 单行单列 还是多行多列
    protected String getSql(CustomerCategory customerCategory , PageHelper pageHelper, boolean flag ) {
        StringBuffer sb = new StringBuffer();//  5表联查  每个表中的数据  必须是状态为 2
        if(flag){ // true 单行单列
            sb.append("select count(*) from customer_category c ");
        }else{
//            sb.append("select c.* , c.customer_state_name , c.customer_source_name , c.customer_category_name , c.username from customer_category c ");
            sb.append("select c.* from customer_category c ");
        }
//        sb.append("left join customer_state cs on c.customer_state_id = cs.customer_state_id and cs.status = 2 ");
//        sb.append("left join customer_source cso on c.customer_source_id = cso.customer_source_id and cso.status = 2 ");
//        sb.append("left join customer_category cc on c.customer_category_id = cc.customer_category_id and cc.status = 2 ");
//        sb.append("left join user u on c.user_id = u.user_id and u.status =2 ");

        sb.append("where c.status = 2 ");
//         会造成sql注入问题  自己补齐
        if (customerCategory.getCustomerCategoryName() != null && customerCategory.getCustomerCategoryName() != "") {
            sb.append(" and c.Customer_Category_Name like '%" + customerCategory.getCustomerCategoryName() + "%' ");
        }
        if (customerCategory.getCustomerCategoryDesc() != null && customerCategory.getCustomerCategoryDesc() != "") {
            sb.append(" and c.Customer_Category_Desc like '%" + customerCategory.getCustomerCategoryDesc() + "%' ");
        }
        if (customerCategory.getCustomerCategoryId() != 0 ){
            sb.append(" and c.Customer_Category_Id like '%" + customerCategory.getCustomerCategoryId() + "%' ");
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

    /**
     * 数据总数
     * @param customerCategory
     * @return
     */
    @Override
    public int count(CustomerCategory customerCategory) {
        String sql = getSql(customerCategory, null, true);
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

    @Override
    public List<CustomerCategory> listByPage(PageHelper pageHelper, CustomerCategory customerCategory) {
        String sql = getSql(customerCategory,pageHelper,false );
        Object [] objects = {} ;
        ResultSet select = DBUtil.select(sql, objects);
        List<CustomerCategory> customerCategorys = new ArrayList<>();
        try {
            while (select.next()){
                CustomerCategory customer1 = fillObject(select);
                customerCategorys.add(customer1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerCategorys ;
    }

    /**
     * 新增
     * @param customerCategory
     * @return
     */
    @Override
    public int add(CustomerCategory customerCategory) {
        String sql = "insert into customer_category(customer_category_name,customer_category_desc,remark,creater,status,create_time) " +
                "values (?,?,?,?,2 , now())";
        Object[] objects = {customerCategory.getCustomerCategoryName() , customerCategory.getCustomerCategoryDesc() , customerCategory.getRemark(),customerCategory.getCreater()};
        int update = DBUtil.update(sql, objects);
        return update;
    }

    @Override
    public int update(CustomerCategory customerCategory) {
        String sql = "update customer_category set customer_category_name=?,customer_category_desc=?,remark=?,update_time=now(),updater=? where customer_category_id=?";
        Object[] objects = {customerCategory.getCustomerCategoryName(),customerCategory.getCustomerCategoryDesc(),customerCategory.getRemark(),customerCategory.getUpdater(),customerCategory.getCustomerCategoryId()};
        int update = DBUtil.update(sql, objects);
        return update ;
    }

    //    删除使用假删除
    @Override
    public int delById(String customerCategoryId) {
        String sql = "update customer_category set status = -2 where customer_category_id = ?";
        Object[] objects = {customerCategoryId};
        int update = DBUtil.update(sql, objects);
        return update ;
    }
}
