package com.cjs.service.impl;

import com.cjs.dao.UserDao;
import com.cjs.model.User;
import com.cjs.service.UserService;
import com.cjs.service.base.BaseServiceImpl;
import com.cjs.util.MD5Util.MD5Util;
import com.cjs.util.exception.MessageException;
import com.cjs.util.session.SessionUtil;
import com.cjs.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
@Component
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void checkUsername(String user_name) {
        User user = userDao.findByPropertyUnique("user_name", user_name);
        if (user != null) {
            throw new MessageException("用户名已存在！");
        }
    }

    @Override
    public User findUser(String user_name) {
        User user = userDao.findByPropertyUnique("user_name", user_name);
        if (user == null) {
            throw new MessageException("未找到该用户！");
        }
        return user;
    }

    @Override
    public void userLogin(String user_name, String user_psd) {
        if (StringUtil.isEmpty(user_name) || StringUtil.isEmpty(user_psd)) {
            throw new MessageException("请填写你的用户名或密码");
        } else {
            User user = userDao.findByPropertyUnique("user_name", user_name.trim());
            if (user == null) {
                throw new MessageException("该用户不存在，请填写正确的用户名");
            } else if (!MD5Util.encode2hex(user_psd).equals(user.getUser_psd())) {
                throw new MessageException("您的密码不正确，请填写正确的密码");
            }
            SessionUtil.bindSession("user", user);
        }

    }

    @Override
    public void userRegister(User user) {
        List<User> users = userDao.findByHql("and user_name = ?", user.getUser_name());
        if (!CollectionUtils.isEmpty(users)) {
            throw new MessageException("该用户已存在");
        }
        user.setUser_psd(MD5Util.encode2hex(user.getUser_psd()));
        userDao.save(user);
    }

    @Override
    public void modifyPassword(Integer user_id, String old_password, String new_password) {
        User user = userDao.findByPropertyUnique("user_id",user_id);
        if (!MD5Util.encode2hex(old_password).equals(user.getUser_psd())) {
            throw new MessageException("当前密码错误！");
        } else if (old_password.equals(new_password)) {
            throw new MessageException("新密码与当前密码一致，请重新填写！");
        }
        user.setUser_psd(new_password);
        userDao.saveOrUpdate(user);
    }

    @Override
    public void userQuit() {
        SessionUtil.logoutSession("user");
    }
}
