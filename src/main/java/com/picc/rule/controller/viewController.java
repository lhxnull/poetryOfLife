package com.picc.rule.controller;

import com.picc.common.utils.FebsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/11/3.
 */
@Controller
public class viewController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/home")
    public String hello() {
        return "photo/home";
    }
    @RequestMapping("/views")
    public String add() {
        return FebsUtil.view("add");
    }

    @RequestMapping("/photo/ynPhotos")
    public String ynPhoto() {
        return "photo/ynPhotos";
    }


    @RequestMapping("/photo/wish")
    public String ynWish() {
        return "photo/wish";
    }

    @RequestMapping("/common")
    public String hellotop() {
        return "common/top";
    }
}
