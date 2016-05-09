package com.cjs.controller;

import com.cjs.controller.base.BaseController;
import com.cjs.model.User;
import com.cjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public void checkUsername(String user_name){
        userService.checkUsername(user_name);
    }

    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestBody User user){
        userService.userLogin(user.getUser_name(),user.getUser_psd());
        return generateSuccessMsg("添加成功!");
    }



    @RequestMapping(value="/userRegister")
    @ResponseBody
    public void userRegister(User user) {
        userService.userRegister(user);
    }

    @RequestMapping(value="/modifyPassword")
    @ResponseBody
    public void modifyPassword(Integer user_id, String old_password, String new_password) {
        userService.modifyPassword(user_id, old_password, new_password);
    }

    @RequestMapping(value="/userQuit")
    @ResponseBody
    public void userQuit(){
        userService.userQuit();
    }
}
