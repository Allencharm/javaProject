package com.blog.controller;

import com.blog.pojo.Blog;
import com.blog.pojo.User;
import com.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/30 14:54
 * @Description: Blog博客Controller
 */
@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    //列表展示--分页
    @GetMapping("list")
    public PageInfo<Blog> list(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10")int pageSize){
        return blogService.findList(currentPage,pageSize);
    }

    //删除博客
    @GetMapping("delete")
    public Map<String,Boolean> delete(int bid){
        blogService.delete(bid);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("flag", true);
        return map;
    }

    //添加功能
    @PostMapping("add")
    public Map<String,Boolean> add(Blog blog, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            blog.setuFk(user.getUid());
        }
        blog.setDate(new Date());
        blogService.save(blog);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("flag", true);
        return map;
    }

    //显示详情
    @GetMapping("showDetail")
    public Blog showDetail(int bid){
        return blogService.findOne(bid);
    }
}
