package com.blog.controller;

import com.blog.pojo.Btype;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //删除小类
    @GetMapping("deleteSmallType")
    public Map<String,Boolean> deleteSmallType(int tid){
        typeService.deleteSmallType(tid);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("flag", true);
        return map;
    }

    //添加小类
    @PostMapping("smallAdd")
    public Map<String,Boolean> smallAdd(Btype btype){
        typeService. smallAdd(btype);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("flag", true);
        return map;
    }

    //删除大类
    @GetMapping("deleteBigType")
    public Map<String,Boolean> deleteBigType(int tid){
        HashMap<String, Boolean> map = new HashMap<>();
        try {
            typeService.deleteBigType(tid);
            map.put("flag", true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("flag", false);
        }
        return map;
    }

    //添加大类
    @PostMapping("bigTypeAdd")
    public Map<String,Boolean> bigTypeAdd(Btype btype){
        HashMap<String, Boolean> map = new HashMap<>();
        typeService.bigTypeAdd(btype);
        map.put("flag", true);
        return map;
    }

    //查看大类
    @GetMapping("showOne")
    public Btype updateBigType(int tid){
        return typeService.showOne(tid);
    }

    //修改大类
    @PostMapping("updateBigType")
    public Map<String,Boolean> updateBigType(Btype btype){
        HashMap<String, Boolean> map = new HashMap<>();
        typeService.updateBigType(btype);
        map.put("flag", true);
        return map;
    }
}
