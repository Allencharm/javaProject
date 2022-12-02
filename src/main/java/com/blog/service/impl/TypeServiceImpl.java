package com.blog.service.impl;

import com.blog.dao.BtypeMapper;
import com.blog.pojo.Btype;
import com.blog.pojo.BtypeExample;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Btype> findBigType() {
        BtypeExample example = new BtypeExample();
        BtypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypePidIsNull();
        return btypeMapper.selectByExample(example);
    }

    @Override
    public List<Btype> findSmallType(int tid) {
        BtypeExample example = new BtypeExample();
        BtypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypePidEqualTo(tid);
        return btypeMapper.selectByExample(example);
    }
}
