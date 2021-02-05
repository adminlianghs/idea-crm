package cn.hp.crm.service;

import cn.hp.crm.model.User;
import cn.hp.crm.util.ResultData;

public interface UserService {
    User login(String username, String password);

    ResultData changePassword(int userId, String password, String newPassword);

    ResultData updateImg(int userId, String url);
}
