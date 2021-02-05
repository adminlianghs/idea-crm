package cn.hp.crm.service.impl;

import cn.hp.crm.dao.UserDao;
import cn.hp.crm.dao.impl.UserDaoImpl;
import cn.hp.crm.model.User;
import cn.hp.crm.service.UserService;
import cn.hp.crm.util.Constant;
import cn.hp.crm.util.ResultData;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * 用户的逻辑层  逻辑层代码量最大 最难
 * 业务层 --> dao 层
 */
public class UserServiceImpl implements UserService {

//    成员变量
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.getByNameAndPassword(username,password);
        return user;
    }

    @Override
    public ResultData changePassword(int userId, String password, String newPassword) {
//        修改密码
//        1、验证原密码是否正确 2、修改新密码
        int count = userDao.getByIdAndPassword(userId , password);
        if (count == 1 ){ // 查询出来了一条数据
//            进行新密码的修改
            int update = userDao.updatePasswordById(userId,newPassword);
            if (update > 0){
                return ResultData.success(Constant.SUCCESS_UPDATE_PASSWORD);
            }else {
                return ResultData.fail(Constant.FAIL_UPDATE_PASSWORD);
            }
        }else {
            return ResultData.fail(Constant.FAIL_UPDATE_PASSWORD_ERROR);
        }

    }

    @Override
    public ResultData updateImg(int userId, String url) {
//        修改头像地址
        int count =userDao.updateImgById(userId,url);
        if (count > 0){ // 把成功之后用户图片地址传递给前端，将页面中的图片进行修改
            return ResultData.success(Constant.SUCCESS_UPDATE_IMG,url);
        }else {
            return ResultData.fail(Constant.FAIL_UPDATE_IMG);
        }
    }


}
