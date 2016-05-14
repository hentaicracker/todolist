package com.cjs.controller;

import com.cjs.controller.base.BaseController;
import com.cjs.model.User;
import com.cjs.service.UserService;
import com.cjs.util.session.SessionUtil;
import com.cjs.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowu on 2016/5/8.
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/checkUsername")
    @ResponseBody
    public Map<String,Object> checkUsername(String user_name) {
        userService.checkUsername(user_name);
        return generateSuccessMsg("验证用户名成功！");
    }

    @RequestMapping(value="/findCurrentUser")
    @ResponseBody
    public User findCurrentUser(){
        User user = userService.findCurrentUser();
        return user;
    }

    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestBody User user){
        try {
            if (user != null) {
                userService.userLogin(user.getUser_name(),user.getUser_psd());
                return generateSuccessMsg("登录成功!");
            }
        } catch (Exception e) {
            return generateFailureMsg("用户名或密码错误！");
        }
        return null;
    }

    @RequestMapping(value="/userRegister")
    @ResponseBody
    public Map<String,Object> userRegister(User user) {
        try {
            if (user != null) {
                userService.userLogin(user.getUser_name(),user.getUser_psd());
                return generateSuccessMsg("注册成功!");
            }
        } catch (Exception e) {
            return generateFailureMsg("注册失败！");
        }
        return null;
    }

    @RequestMapping(value="/modifyPassword")
    @ResponseBody
    public Map<String,Object> modifyPassword(Integer user_id, String old_password, String new_password) {
        userService.modifyPassword(user_id, old_password, new_password);
        return generateSuccessMsg("修改密码成功！");
    }

    @RequestMapping(value="/userQuit")
    @ResponseBody
    public Map<String,Object> userQuit(){
        userService.userQuit();
        return generateSuccessMsg("退出成功！");
    }
}
