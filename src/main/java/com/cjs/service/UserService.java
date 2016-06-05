package com.cjs.service;

import com.cjs.model.User;

/**
 * 2016/5/8
 */
public interface UserService {
    /**
     * 检查用户名
     * @param user_name
     */
    void checkUsername(String user_name);

    /**
     * 根据用户名拿到用户对象
     * @return
     */
    User findCurrentUser();

    /**
     * 用户登录
     * @param user_name
     * @param user_psd
     */
    void userLogin(String user_name, String user_psd);

    /**
     * 用户注册
     * @param user
     */
    void userRegister(User user);

    /**
     * 修改密码
     * @param user_id
     * @param old_password
     * @param new_password
     */
    void modifyPassword(Integer user_id, String old_password, String new_password);

    /**
     * 用户注销
     */
    void userQuit();
}
