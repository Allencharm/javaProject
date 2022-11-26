package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/17 14:56
 * @Description:
 */
public interface UserService {
    List<User> findList();

    User findOne(int uid);

    void edit(User user);

    void delete(int uid);

    void save(User user);
}
