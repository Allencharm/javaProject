package com.blog.service;

import com.blog.pojo.Blog;
import com.github.pagehelper.PageInfo;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/30 14:59
 * @Description:
 */
public interface BlogService {

    PageInfo<Blog> findList(int currentPage, int pageSize);

    void delete(int bid);
}
