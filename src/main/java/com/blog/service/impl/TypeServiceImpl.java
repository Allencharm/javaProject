package com.blog.service.impl;

import com.blog.dao.BlogMapper;
import com.blog.dao.BtypeMapper;
import com.blog.pojo.Blog;
import com.blog.pojo.BlogExample;
import com.blog.pojo.Btype;
import com.blog.pojo.BtypeExample;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 11:00
 * @Description: 类型接口的实现
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private BtypeMapper btypeMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Btype> findBigType() {
        BtypeExample example = new BtypeExample();
        BtypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypePidIsNull();
        List<Btype> bigTypeList = btypeMapper.selectByExample(example);
        for (Btype btype : bigTypeList){
            Integer typeid = btype.getTypeid();
            List<Btype> smallType = findSmallType(typeid);
            btype.setSmallTypeList(smallType);
        }
        return bigTypeList;
    }

    @Override
    public List<Btype> findSmallType(int tid) {
        BtypeExample example = new BtypeExample();
        BtypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypePidEqualTo(tid);
        return btypeMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void deleteSmallType(int tid) {
        //先进性关联操作--查博客表中是否有当前小类使用，如果有先博客表中小类外键改为null，然后删除小类，如果没有则直接删除小类
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andTypeFkEqualTo(tid);
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        //先改造
        if (blogs != null && blogs.size() > 0){
            for (Blog blog : blogs){
                blog.setTypeFk(null);
                blogMapper.updateByPrimaryKey(blog);
            }
        }
        //删小类
        btypeMapper.deleteByPrimaryKey(tid);
    }
}
