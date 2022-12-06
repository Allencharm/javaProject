package com.blog.controller;

import com.blog.pojo.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/6 10:45
 * @Description: 用户功能
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //登陆
    @PostMapping("login")
    public Map<String,Boolean> login(String uname, String upass, HttpSession session){
        HashMap<String, Boolean> map = new HashMap<>();
        try {
            User user = userService.login(uname,upass);
            if (user != null){
                map.put("flag", true);
                session.setAttribute("user", user);
            }else {
                map.put("flag", false);
            }
        }catch (Exception e){
            map.put("flag", false);
            e.printStackTrace();
        }
        return map;
    }

    //登出
    @GetMapping("logout")
    public Map<String,Boolean> logout(HttpSession session){
        HashMap<String, Boolean> map = new HashMap<>();
        session.invalidate();
        map.put("flag", true);
        return map;
    }
}
