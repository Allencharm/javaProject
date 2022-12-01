package com.blog.service.impl;

import com.blog.dao.BlogMapper;
import com.blog.dao.BtypeMapper;
import com.blog.dao.EvaluateMapper;
import com.blog.dao.UserMapper;
import com.blog.pojo.Blog;
import com.blog.pojo.Btype;
import com.blog.pojo.EvaluateExample;
import com.blog.pojo.User;
import com.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private BtypeMapper btypeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public PageInfo<Blog> findList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Blog> blogs = blogMapper.selectByExample(null);
        for (Blog blog : blogs) {
            Integer typeFk = blog.getTypeFk();
            Btype btype = btypeMapper.selectByPrimaryKey(typeFk);
            blog.setBtype(btype);
            Integer uFk = blog.getuFk();
            User user = userMapper.selectByPrimaryKey(uFk);
            blog.setUser(user);

        }
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs, 5);
        return pageInfo;
    }

    //删除博客，删除评论
    @Override
    @Transactional
    public void delete(int bid) {
        //先删除评论
        EvaluateExample example = new EvaluateExample();
        EvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andBFkEqualTo(bid);
        evaluateMapper.deleteByExample(example);
        //删除博客
        blogMapper.deleteByPrimaryKey(bid);
    }
}
