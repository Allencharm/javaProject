package com.blog.service;

import com.blog.pojo.Btype;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 11:00
 * @Description:
 */
public interface TypeService {
    List<Btype> findBigType();

    List<Btype> findSmallType(int tid);

}
