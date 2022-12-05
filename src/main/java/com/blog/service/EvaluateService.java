package com.blog.service;

import com.blog.pojo.Evaluate;
import com.github.pagehelper.PageInfo;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 16:17
 * @Description:
 */
public interface EvaluateService {
    void deleteOne(int eid);

    PageInfo<Evaluate> findList(int currentPage, int pageSize);
}
