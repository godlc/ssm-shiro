package com.wtu.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HASEE on 2018/4/1.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @RequestMapping("/queryItems")
    @RequiresPermissions("item:query")
    @ResponseBody
    public String queryItems(HttpServletRequest request){
        return "OK";
    }
    @RequestMapping("/editItems")
    @RequiresPermissions("item:yy")
    @ResponseBody
    public String editItems(HttpServletRequest request){
        return "OK";
    }
}
