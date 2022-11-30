package com.blog.controller;

import com.blog.pojo.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("list")
    public PageInfo<Blog> list(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10")int pageSize){
        return blogService.findList(currentPage,pageSize);
    }
}
