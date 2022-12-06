package com.blog.service.impl;

import com.blog.dao.UserMapper;
import com.blog.pojo.User;
import com.blog.pojo.UserExample;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/6 10:52
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String uname, String upass) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUnameEqualTo(uname);
        criteria.andUpassEqualTo(upass);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }
}
