package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/8 20:56
 * @Description:
 */
@Controller
public class FirstController {

    @GetMapping("first")
    public String first(){
        return "list";
    }
}
