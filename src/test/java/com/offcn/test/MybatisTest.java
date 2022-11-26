package com.offcn.test;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/10 13:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1(){
        List<User> users = userDao.selectList();
        System.out.println(users);
    }
}
