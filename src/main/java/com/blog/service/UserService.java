package com.blog.service;

import com.blog.pojo.User;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/6 10:52
 * @Description:
 */
public interface UserService {
    User login(String uname, String upass);
}
