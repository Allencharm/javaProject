package com.offcn.dao;

import com.offcn.pojo.User;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/10 13:46
 * @Description:
 */
public interface UserDao {

    public List<User> selectList();

    User selectOne(int uid);

    void update(User user);

    void delete(int uid);

    void save(User user);
}
