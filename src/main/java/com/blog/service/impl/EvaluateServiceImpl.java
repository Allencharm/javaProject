package com.blog.service.impl;

import com.blog.dao.EvaluateMapper;
import com.blog.pojo.Evaluate;
import com.blog.service.EvaluateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 16:18
 * @Description: 评论的实现接口
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public void deleteOne(int eid) {
        evaluateMapper.deleteByPrimaryKey(eid);
    }

    //列表查询
    @Override
    public PageInfo<Evaluate> findList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Evaluate> evaluates = evaluateMapper.selectByExample(null);
        PageInfo<Evaluate> pageInfo = new PageInfo<>(evaluates, 5);
        return pageInfo;
    }
}
