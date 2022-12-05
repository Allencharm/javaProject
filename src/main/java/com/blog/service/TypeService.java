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

    void deleteSmallType(int tid);

    void smallAdd(Btype btype);

    void deleteBigType(int tid);

    void bigTypeAdd(Btype btype);

    Btype showOne(int tid);

    void updateBigType(Btype btype);
}
