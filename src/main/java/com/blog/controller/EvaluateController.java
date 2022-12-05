package com.blog.controller;

import com.blog.pojo.Evaluate;
import com.blog.service.EvaluateService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/12/2 16:14
 * @Description: 评论
 */
@RestController
@RequestMapping("evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @GetMapping("delete")
    public Map<String,Boolean> deleteEva(int eid){
        evaluateService.deleteOne(eid);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("flag", true);
        return map;
    }

    @GetMapping("list")
    public PageInfo<Evaluate> list(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int pageSize){
        return evaluateService.findList(currentPage,pageSize);
    }

}
