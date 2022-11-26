package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/17 14:57
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //查询所有
    public List<User> findList() {
        return userDao.selectList();
    }

    //主键查询
    public User findOne(int uid) {
        return userDao.selectOne(uid);
    }

    //修改功能
    public void edit(User user) {
        userDao.update(user);
    }

    //删除功能
    public void delete(int uid) {
        userDao.delete(uid);
    }

    //添加功能
    public void save(User user) {
        userDao.save(user);
    }


}
