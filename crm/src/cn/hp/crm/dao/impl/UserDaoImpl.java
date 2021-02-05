package cn.hp.crm.dao.impl;

import cn.hp.crm.dao.UserDao;
import cn.hp.crm.model.User;
import cn.hp.crm.util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  dao层 操作数据库 进行增删改查
 *  所有sql操作的都是 user表
 */
public class UserDaoImpl implements UserDao {

//    两种操作语句  1、DML 操作语句  返回影响行
//                 2、 DQL 查询语句  返回结果集 （ 0~n个user对象 ）

//    将查询的值装载到 user 对象中
    protected User fillObject(ResultSet set) throws SQLException {
        User user = null ;
        if (set.next()){
            user = new User();
            user.setUsername(set.getString("username"));
            user.setUserId(set.getInt("user_id"));
            user.setUpdateTime(set.getTimestamp("update_time"));
            user.setUpdater(set.getInt("updater"));
            user.setTel(set.getString("tel"));
            user.setStatus(set.getByte("status"));
            user.setRoleId(set.getInt("role_id"));
            user.setRemark(set.getString("remark"));
            user.setPassword(set.getString("password"));
            user.setNation(set.getString("nation"));
            user.setMobile(set.getString("mobile"));
            user.setMarry(set.getByte("marry"));
            user.setIsSystem(set.getByte("is_system"));
            user.setIsMale(set.getByte("is_male"));
            user.setIsAdmin(set.getByte("is_admin"));
            user.setIdNum(set.getString("id_num"));
            user.setHobby(set.getString("hobby"));
            user.setEmail(set.getString("email"));
            user.setEducation(set.getByte("education"));
            user.setDepartmentId(set.getInt("department_id"));
            user.setCreateTime(set.getTimestamp("create_time"));
            user.setCreater(set.getInt("creater"));
            user.setCardNum(set.getString("card_num"));
            user.setAge(set.getInt("age"));
            user.setAddress(set.getString("address"));
            user.setUserImg(set.getString("user_img"));
        }
        return user ;
    }

//     根据账号 密码 查询是否有当前用户
    @Override
    public User getByNameAndPassword(String username, String password) {
//         如何设计dao层， 可以不再每个方法中 重复写 sql 语句
        String sql = "select * from user where username = ? and password =? and status = 2";
//        String sql1 = "select * from user where id = ? and status = 2 ";
//        String sql2 = "select count(*) from user where username = ? and password = ? and status = 2 ";
        Object[] objs = {username ,password};
        ResultSet select = DBUtil.select(sql, objs);
        User user = null;
        try {
            user = fillObject(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getByIdAndPassword(int userId, String password) {
        String sql = "select count(*) from user where user_id =? and password = ? and status = 2";
        Object[] objects = {userId , password};
        ResultSet select = DBUtil.select(sql, objects);
        try {
            if (select.next()){
                return select.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0 ;
    }

    @Override
    public int updatePasswordById(int userId, String newPassword) {
        String sql = "update user set password = ? where user_id = ? and status = 2 " ;
        Object[] objects = {newPassword , userId};
        int update = DBUtil.update(sql, objects);
        return update;
    }

    @Override
    public int updateImgById(int userId, String url) {
        String sql = "update user set user_img = ? where user_id = ? and status =2 ";
        Object [] objects = {url ,userId};
        int update = DBUtil.update(sql, objects);
        return update;
    }
}
