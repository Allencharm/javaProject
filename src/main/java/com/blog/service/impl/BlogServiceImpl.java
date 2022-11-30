package com.blog.service.impl;

import com.blog.dao.BlogMapper;
import com.blog.pojo.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/30 15:00
 * @Description: BlogService接口实现类
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public PageInfo<Blog> findList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Blog> blogs = blogMapper.selectByExample(null);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs, 5);
        return pageInfo;
    }
}
