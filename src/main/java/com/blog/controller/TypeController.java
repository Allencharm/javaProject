package com.blog.controller;

import com.blog.pojo.Btype;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 10:56
 * @Description: 类型管理
 */
@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //显示大类
    @GetMapping("showBigType")
    public List<Btype> showBigType(){
        return typeService.findBigType();
    }

    //根据大类Id显示小类信息
    @GetMapping("showSmallType")
    public List<Btype> showSmallType(int tid){
        return typeService.findSmallType(tid);
    }
}
