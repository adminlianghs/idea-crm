package cn.hp.crm.dao;

import cn.hp.crm.model.User;

public interface UserDao {
    User getByNameAndPassword(String username, String password);

    int getByIdAndPassword(int userId, String password);

    int updatePasswordById(int userId, String newPassword);

    int updateImgById(int userId, String url);
}
