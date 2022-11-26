package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/17 14:52
 * @Description: 用户功能管理
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list(Model model){
        List<User> list = userService.findList();
        model.addAttribute("list", list);
        return "user-list";
    }

    //回显数据
    @GetMapping("edit/{id}")
    public String show(@PathVariable("id") int uid, Model model){
        User user = userService.findOne(uid);
        model.addAttribute("user", user);
        return "user-update";
    }

    //修改数据
    @PutMapping("edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/user/list";
    }

    //删除数据
    @DeleteMapping("delete")
    public String delete(int uid){
        userService.delete(uid);
        return "redirect:/user/list";
    }

    //进入添加页面
    @GetMapping("toAdd")
    public String toAdd(){
        return "user-add";
    }

    //添加功能
    @PostMapping("add")
    public String add(User user){
        userService.save(user);
        return "redirect:/user/list";
    }
}
