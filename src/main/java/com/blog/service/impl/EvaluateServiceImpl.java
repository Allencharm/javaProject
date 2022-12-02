package com.blog.service.impl;

import com.blog.dao.EvaluateMapper;
import com.blog.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
